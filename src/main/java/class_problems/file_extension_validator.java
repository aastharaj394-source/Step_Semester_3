package class_problems;
import java.util.Scanner;
public class file_extension_validator {
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Rejected — invalid file type";
        }
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = filename.substring(dotIndex + 1).toLowerCase();
        if (extension.equals("pdf") || extension.equals("docx") || extension.equals("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename with extension: ");
        String filename = scanner.nextLine().trim();

        String status = validateFileExtension(filename);
        System.out.println(status);

        scanner.close();
    }
}
