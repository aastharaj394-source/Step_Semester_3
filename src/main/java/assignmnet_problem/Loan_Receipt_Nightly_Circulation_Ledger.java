package assignmnet_problem;
import java.util.Scanner;
import java.util.Arrays;
public class Loan_Receipt_Nightly_Circulation_Ledger {
    class LoanReceipt {
        private final String memberId;
        private final String[] bookIds;

        public LoanReceipt(String memberId, String[] bookIds) {
            this.memberId = memberId;
            if (bookIds != null) {
                this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
            } else {
                this.bookIds = new String[0];
            }
        }

        public String getMemberId() {
            return memberId;
        }

        public String[] getBookIds() {
            return Arrays.copyOf(bookIds, bookIds.length);
        }

        public LoanReceipt withCorrectedBookId(int index, String newId) {
            String[] copy = Arrays.copyOf(bookIds, bookIds.length);
            if (index >= 0 && index < copy.length) {
                copy[index] = newId;
            }
            return new LoanReceipt(this.memberId, copy);
        }
    }

    class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }

        public String getRoomNumber() {
            return roomNumber;
        }
    }

    public class CirculationLedger {
        static String branchCode;

        static {
            branchCode = "PT-CENTRAL";
        }

        public static String processNightlyCirculation(LoanReceipt[] receipts) {
            int processed = 0;
            int skipped = 0;
            int referenceOnly = 0;
            int regular = 0;

            if (receipts != null) {
                for (LoanReceipt r : receipts) {
                    if (r == null) {
                        skipped++;
                    } else {
                        processed++;
                        if (r instanceof ReferenceOnlyLoanReceipt) {
                            referenceOnly++;
                        } else {
                            regular++;
                        }
                    }
                }
            }

            return processed + " processed | " + skipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            LoanReceipt[] receipts = new LoanReceipt[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("null")) {
                    receipts[i] = null;
                } else {
                    String[] parts = line.split(",");
                    String type = parts[0].trim();
                    String id = parts[1].trim();
                    String[] books = parts[2].trim().split(" ");

                    if (type.equalsIgnoreCase("reference")) {
                        String room = parts[3].trim();
                        receipts[i] = new ReferenceOnlyLoanReceipt(id, books, room);
                    } else {
                        receipts[i] = new LoanReceipt(id, books);
                    }
                }
            }

            System.out.println(processNightlyCirculation(receipts));
            scanner.close();
        }
    }
}
