package class_problem;
import java.util.Scanner;
public class Three_Branches_of_the_Membership_Tree_Java {
    class LibraryMemberTree {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMemberTree(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public void borrowBook() {
            this.booksBorrowed++;
        }

        public int getBooksBorrowed() {
            return this.booksBorrowed;
        }

        public String displayInfo() {
            return "General Member | Books Borrowed: " + this.booksBorrowed;
        }
    }

    class StudentMemberTree extends LibraryMemberTree {
        protected String course;

        public StudentMemberTree(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        @Override
        public String displayInfo() {
            return "Student Member | Course: " + this.course + " | Books Borrowed: " + this.booksBorrowed;
        }
    }

    class HonorsStudentMember extends StudentMemberTree {
        private int bonusLimit;

        public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
            super(memberId, borrowLimit, course);
            this.bonusLimit = bonusLimit;
        }

        @Override
        public String displayInfo() {
            return "Honors Student Member | Course: " + this.course + " | Bonus Limit: " + this.bonusLimit + " | Books Borrowed: " + this.booksBorrowed;
        }
    }

    class FacultyMember extends LibraryMemberTree {
        private String department;

        public FacultyMember(String memberId, int borrowLimit, String department) {
            super(memberId, borrowLimit);
            this.department = department;
        }

        @Override
        public String displayInfo() {
            return "Faculty Member | Department: " + this.department + " | Books Borrowed: " + this.booksBorrowed;
        }
    }

    public class LibraryHierarchyDemo {

        public static String classifyGeneration(LibraryMemberTree member) {
            if (member instanceof HonorsStudentMember) {
                return "Multilevel descendant (3 generations deep)";
            } else if (member instanceof FacultyMember) {
                return "Hierarchical sibling (independent branch)";
            } else if (member instanceof StudentMemberTree) {
                return "Direct subclass (2 generations deep)";
            } else {
                return "Base class";
            }
        }

        public static int getTotalBooksBorrowed(LibraryMemberTree[] members) {
            int total = 0;
            for (LibraryMemberTree m : members) {
                if (m != null) {
                    total += m.getBooksBorrowed();
                }
            }
            return total;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            LibraryMemberTree[] list = new LibraryMemberTree[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String id = parts[1].trim();
                int limit = Integer.parseInt(parts[2].trim());
                int borrowed = Integer.parseInt(parts[3].trim());

                LibraryMemberTree member;
                if (type.equalsIgnoreCase("Honors")) {
                    member = new HonorsStudentMember(id, limit, parts[4].trim(), Integer.parseInt(parts[5].trim()));
                } else if (type.equalsIgnoreCase("Student")) {
                    member = new StudentMemberTree(id, limit, parts[4].trim());
                } else if (type.equalsIgnoreCase("Faculty")) {
                    member = new FacultyMember(id, limit, parts[4].trim());
                } else {
                    member = new LibraryMemberTree(id, limit);
                }

                for (int b = 0; b < borrowed; b++) {
                    member.borrowBook();
                }
                list[i] = member;
            }

            for (LibraryMemberTree m : list) {
                System.out.println(m.displayInfo());
                System.out.println(classifyGeneration(m));
            }

            System.out.println(getTotalBooksBorrowed(list));

            scanner.close();
        }
    }
}
