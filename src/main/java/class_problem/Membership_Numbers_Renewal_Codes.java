package class_problem;
import java.util.Scanner;
public class Membership_Numbers_Renewal_Codes {
    class AuditLibraryMember {
        private static int counter = 100;
        private static int membersEnrolled = 0;

        public final String memberNumber;
        private int booksBorrowed;

        public AuditLibraryMember(int borrowLimit) {
            counter++;
            membersEnrolled++;
            this.memberNumber = "LIB-" + counter;
            this.booksBorrowed = 0;
        }

        public static int getMembersEnrolled() {
            return membersEnrolled;
        }

        public void borrowBook() {
            this.booksBorrowed++;
        }

        public void borrowBook(String genre) {
            borrowBook();
        }

        public int getBooksBorrowed() {
            return this.booksBorrowed;
        }

        public static boolean isValidRenewalCode(String code) {
            if (code == null || code.length() != 4) {
                return false;
            }
            if (code.charAt(0) != 'R') {
                return false;
            }
            if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
                return false;
            }
            if (!Character.isUpperCase(code.charAt(3)) || !Character.isLetter(code.charAt(3))) {
                return false;
            }
            return true;
        }
    }

    class AuditFacultyMember extends AuditLibraryMember {
        private String department;

        public AuditFacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = department;
        }

        public String getDepartment() {
            return this.department;
        }
    }

    public class NightlyCirculationAudit {

        public static String processNightlyAudit(AuditLibraryMember[] members) {
            int processed = 0;
            int skipped = 0;
            int faculty = 0;
            int regular = 0;

            if (members != null) {
                for (AuditLibraryMember m : members) {
                    if (m == null) {
                        skipped++;
                    } else {
                        processed++;
                        if (m instanceof AuditFacultyMember) {
                            faculty++;
                        } else {
                            regular++;
                        }
                    }
                }
            }

            return processed + " processed | " + skipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int refCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < refCount; i++) {
                String code = scanner.nextLine().trim();
                System.out.println(AuditLibraryMember.isValidRenewalCode(code));
            }

            int memberCount = Integer.parseInt(scanner.nextLine().trim());
            AuditLibraryMember[] members = new AuditLibraryMember[memberCount];

            for (int i = 0; i < memberCount; i++) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("null")) {
                    members[i] = null;
                } else {
                    String[] parts = line.split(",");
                    String type = parts[0].trim();
                    int limit = Integer.parseInt(parts[1].trim());

                    if (type.equalsIgnoreCase("Faculty")) {
                        String dept = parts[2].trim();
                        members[i] = new AuditFacultyMember(limit, dept);
                    } else {
                        members[i] = new AuditLibraryMember(limit);
                    }
                }
            }

            System.out.println(processNightlyAudit(members));

            scanner.close();
        }
    }
}
