package class_problems;
import java.util.Scanner;
public class Warehouse_Label_Printer {
    interface Printable {
        String printLabel();
    }

    class PackageBox implements Printable {
        private String trackingId;

        public PackageBox(String trackingId) {
            this.trackingId = trackingId;
        }

        @Override
        public String printLabel() {
            return "Package label: " + trackingId;
        }
    }

    class Invoice implements Printable {
        private String invoiceNumber;

        public Invoice(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        @Override
        public String printLabel() {
            return "Invoice label: " + invoiceNumber;
        }
    }

    public class WarehousePrinterDemo {
        public static void printAll(Printable[] items) {
            for (Printable item : items) {
                System.out.println(item.printLabel());
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            Printable[] items = new Printable[n];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String id = parts[1].trim();

                if (type.equalsIgnoreCase("Package")) {
                    items[i] = new PackageBox(id);
                } else {
                    items[i] = new Invoice(id);
                }
            }

            printAll(items);
            scanner.close();
        }
    }
}
