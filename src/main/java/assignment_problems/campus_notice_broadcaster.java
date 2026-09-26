package assignment_problems;
import java.util.*;

interface NotificationChannel {
    void send(String studentName, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[Email → " + studentName + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[SMS → " + studentName + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[App → " + studentName + "] " + message);
    }
}

class Student {
    private String name;
    private String department;
    private ArrayList<NotificationChannel> channels;

    Student(String name, String department) {
        this.name = name;
        this.department = department;
        channels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public void receiveNotice(String message) {
        for (NotificationChannel channel : channels) {
            channel.send(name, message);
        }
    }
}

class Notice {
    private String title;
    private HashSet<String> departments;

    Notice(String title, HashSet<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    public boolean isValid() {
        return title != null &&
                !title.trim().isEmpty() &&
                !departments.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public HashSet<String> getDepartments() {
        return departments;
    }
}

class NoticeBoard {
    private ArrayList<Student> students;

    NoticeBoard() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void postNotice(Notice notice) {
        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.print("Notice '" + notice.getTitle() +
                "' posted to ");

        int count = 0;

        for (String department : notice.getDepartments()) {
            System.out.print(department);

            count++;

            if (count < notice.getDepartments().size()) {
                System.out.print(", ");
            }
        }

        System.out.println(".");

        for (Student student : students) {
            if (notice.getDepartments()
                    .contains(student.getDepartment())) {

                student.receiveNotice(notice.getTitle());
            }
        }
    }
}

public class Main {
    public static NotificationChannel createChannel(String channel) {
        if (channel.equalsIgnoreCase("Email")) {
            return new EmailChannel();
        } else if (channel.equalsIgnoreCase("SMS")) {
            return new SmsChannel();
        } else {
            return new AppChannel();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NoticeBoard board = new NoticeBoard();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            Student student = new Student(name, department);

            System.out.print("Enter number of preferred channels: ");
            int channels = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < channels; j++) {
                System.out.print("Enter channel (Email/SMS/App): ");
                String channel = sc.nextLine();

                student.addChannel(createChannel(channel));
            }

            board.addStudent(student);
        }

        System.out.print("\nEnter notice title: ");
        String title = sc.nextLine();

        System.out.print("Enter number of target departments: ");
        int departmentCount = sc.nextInt();
        sc.nextLine();

        HashSet<String> departments = new HashSet<>();

        for (int i = 0; i < departmentCount; i++) {
            System.out.print("Enter target department: ");
            departments.add(sc.nextLine());
        }

        Notice notice = new Notice(title, departments);

        board.postNotice(notice);

        sc.close();
    }
}