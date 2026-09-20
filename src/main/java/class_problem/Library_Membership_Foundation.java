package class_problem;
import java.util.Scanner;
public class Library_Membership_Foundation {
    class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId: must be non-blank and at least 4 characters");
            }
            this.memberId = memberId.trim();
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public void borrowBook() {
            this.booksBorrowed++;
        }

        public int getBooksBorrowed() {
            return this.booksBorrowed;
        }

        public static String enrollBatch(String[] memberIds, int borrowLimit) {
            int enrolled = 0;
            int rejected = 0;

            for (String id : memberIds) {
                try {
                    new LibraryMember(id, borrowLimit);
                    enrolled++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
            return "Enrolled: " + enrolled + " | Rejected: " + rejected;
        }
    }

    class StudentMember extends LibraryMember {
        protected String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        public String getCourse() {
            return this.course;
        }
    }

    public class LibraryBatchEnrollment {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int limit = Integer.parseInt(scanner.nextLine().trim());
            int n = Integer.parseInt(scanner.nextLine().trim());

            String[] ids = new String[n];
            for (int i = 0; i < n; i++) {
                ids[i] = scanner.nextLine();
            }

            System.out.println(LibraryMember.enrollBatch(ids, limit));

            scanner.close();
        }
    }k
}
