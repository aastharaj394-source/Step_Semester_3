package class_problem;
import java.util.Scanner;
public class The_Student_Discount {
    class LibraryMemberWithLedger {
        protected String memberId;
        protected int borrowLimit;
        private int[] fineHistory;
        private int fineCount;

        public LibraryMemberWithLedger(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.fineHistory = new int[10];
            this.fineCount = 0;
        }

        protected void chargeFine(int amount) {
            if (fineCount < fineHistory.length) {
                fineHistory[fineCount++] = amount;
            }
        }

        public int[] getFineHistory() {
            return Arrays.copyOf(fineHistory, fineCount);
        }

        public int getTotalFine() {
            int sum = 0;
            for (int i = 0; i < fineCount; i++) {
                sum += fineHistory[i];
            }
            return sum;
        }
    }

    class StudentMemberWithLedger extends LibraryMemberWithLedger {
        private String course;

        public StudentMemberWithLedger(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }
    }

    public class LibraryFineLedgerDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String id = scanner.nextLine().trim();
            int limit = Integer.parseInt(scanner.nextLine().trim());
            String course = scanner.nextLine().trim();

            StudentMemberWithLedger student = new StudentMemberWithLedger(id, limit, course);

            int count = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < count; i++) {
                int fine = Integer.parseInt(scanner.nextLine().trim());
                student.chargeFine(fine);
            }

            System.out.println(student.getTotalFine());

            int[] history = student.getFineHistory();
            System.out.println(Arrays.toString(history));

            scanner.close();
        }
    }
}
