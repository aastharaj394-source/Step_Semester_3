package class_problem;
import java.util.Scanner;
public class The_Weekly_Circulation_Report {
    class ReportLibraryMember {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public ReportLibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public String displayInfo() {
            return "General | Books: " + this.booksBorrowed;
        }
    }

    class ReportStudentMember extends ReportLibraryMember {
        private String course;

        public ReportStudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        public String getCourse() {
            return this.course;
        }

        @Override
        public String displayInfo() {
            return "Student | Course: " + this.course + " | Books: " + this.booksBorrowed;
        }
    }

    public class WeeklyCirculationReport {

        public static String batchPrint(ReportLibraryMember[] members) {
            StringBuilder sb = new StringBuilder();

            for (ReportLibraryMember m : members) {
                sb.append(m.displayInfo());

                if (m instanceof ReportStudentMember) {
                    ReportStudentMember sm = (ReportStudentMember) m;
                    sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
                }

                sb.append(" | ");
            }

            return sb.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            ReportLibraryMember[] members = new ReportLibraryMember[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String id = parts[1].trim();
                int limit = Integer.parseInt(parts[2].trim());

                if (type.equalsIgnoreCase("Student")) {
                    String course = parts[3].trim();
                    members[i] = new ReportStudentMember(id, limit, course);
                } else {
                    members[i] = new ReportLibraryMember(id, limit);
                }
            }

            System.out.println(batchPrint(members));

            scanner.close();
        }
    }
}
