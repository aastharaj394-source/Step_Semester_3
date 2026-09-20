package assignment_problem;
import java.util.Scanner;
public class product_inventory {
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();
        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter inventory record (CSV format: ProductName,SKU,Quantity): ");
        String line = scanner.nextLine();
        parseInventoryRecord(line);
        scanner.close();
    }
}
