package Class_problem;
import java.util.Scanner;
import java.util.Arrays;
public class Booking_Receipt_Nightly_settlement {
    final class BookingReceipt {
        private final String bookingId;
        private final String[] seatNumbers;

        public BookingReceipt(String bookingId, String[] seatNumbers) {
            this.bookingId = bookingId;
            if (seatNumbers != null) {
                this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
            } else {
                this.seatNumbers = new String[0];
            }
        }

        public String getBookingId() {
            return bookingId;
        }

        public String[] getSeatNumbers() {
            return Arrays.copyOf(seatNumbers, seatNumbers.length);
        }

        public BookingReceipt withUpdatedSeat(int index, String newSeat) {
            String[] copy = Arrays.copyOf(seatNumbers, seatNumbers.length);
            if (index >= 0 && index < copy.length) {
                copy[index] = newSeat;
            }
            return new BookingReceipt(this.bookingId, copy);
        }
    }

    class GroupBookingReceipt extends BookingReceipt {
        private final int groupSize;

        public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
            super(bookingId, seatNumbers);
            this.groupSize = groupSize;
        }

        public int getGroupSize() {
            return groupSize;
        }
    }

    public class NightlySettlementProcessor {

        public static String processNightlySettlement(BookingReceipt[] receipts) {
            int processed = 0;
            int skipped = 0;
            int group = 0;
            int individual = 0;

            if (receipts != null) {
                for (BookingReceipt r : receipts) {
                    if (r == null) {
                        skipped++;
                    } else {
                        processed++;
                        if (r instanceof GroupBookingReceipt) {
                            group++;
                        } else {
                            individual++;
                        }
                    }
                }
            }

            return processed + " processed | " + skipped + " null skipped | " + group + " group | " + individual + " individual";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            BookingReceipt[] receipts = new BookingReceipt[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("null")) {
                    receipts[i] = null;
                } else {
                    String[] parts = line.split(",");
                    String type = parts[0].trim();
                    String id = parts[1].trim();
                    String[] seats = parts[2].trim().split(" ");

                    if (type.equalsIgnoreCase("group")) {
                        int groupSize = Integer.parseInt(parts[3].trim());
                        receipts[i] = new GroupBookingReceipt(id, seats, groupSize);
                    } else {
                        receipts[i] = new BookingReceipt(id, seats);
                    }
                }
            }

            System.out.println(processNightlySettlement(receipts));
            scanner.close();
        }
    }
}
