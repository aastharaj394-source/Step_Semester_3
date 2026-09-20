package assignment_problem;
import java.util.Scanner;
public class Library_inventory {
    class BookInventory {
        String title;
        String author;
        int copiesAvailable;
        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        public void printEntry() {
            System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
        }
    }
    public class LibraryInventoryManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BookInventory[] inventory = new BookInventory[4];
            System.out.println("Enter 4 book records (format: Title, Author, Copies):");
            for (int i = 0; i < 4; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");

                String title = parts[0].trim();
                String author = parts[1].trim();
                int copies = Integer.parseInt(parts[2].trim());

                inventory[i] = new BookInventory(title, author, copies);
            }
            System.out.println("\n--- Inventory Details ---");
            for (BookInventory book : inventory) {
                book.printEntry();
            }

            scanner.close();
        }
    }
}
