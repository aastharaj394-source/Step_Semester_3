package Class_problem;
import java.util.Scanner;
public class subclass_ticket_access {
    public class SubclassAccessChecker {

        public static String classifyAccess(String fieldModifier, String accessorContext) {
            switch (fieldModifier.toLowerCase()) {
                case "public":
                    return "ALLOWED";
                case "protected":
                    if (accessorContext.equals("SAME_CLASS")
                            || accessorContext.equals("SAME_PACKAGE")
                            || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                case "default":
                    if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                case "private":
                    if (accessorContext.equals("SAME_CLASS")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                default:
                    return "DENIED";
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String modifier = parts[0].trim();
                String context = parts[1].trim();

                System.out.println(classifyAccess(modifier, context));
            }

            scanner.close();
        }
    }
}
