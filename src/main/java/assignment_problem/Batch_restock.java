package assignment_problem;
import java.util.Scanner;
public class Batch_restock {
    class Item {
        String itemName;
        int stock;

        public Item(String itemName, int stock) {
            this.itemName = itemName;
            this.stock = stock;
        }

        public void restock(int stock) {
            this.stock += stock;
        }
    }

    public class CanteenRestock {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of items: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            Item[] items = new Item[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter item name: ");
                String name = scanner.nextLine().trim();

                System.out.print("Enter starting stock: ");
                int stock = Integer.parseInt(scanner.nextLine().trim());

                items[i] = new Item(name, stock);
            }

            System.out.print("Enter restock quantity to apply to all: ");
            int restockAmount = Integer.parseInt(scanner.nextLine().trim());

            System.out.println();
            for (int i = 0; i < n; i++) {
                items[i].restock(restockAmount);
                System.out.println(items[i].itemName + " | Final Stock: " + items[i].stock);
            }

            scanner.close();
        }
    }
}
