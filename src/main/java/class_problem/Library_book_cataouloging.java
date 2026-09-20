package class_problem;
import java.util.Scanner;
public class Library_book_cataouloging {
    class LibraryBook {
        String title;
        String isbn;
        boolean catalogued;

        // Two-argument constructor
        public LibraryBook(String title, String isbn) {
            this.title = title;
            if (isbn == null || isbn.trim().isEmpty()) {
                this.isbn = "PENDING";
            } else {
                this.isbn = isbn.trim();
            }
            this.catalogued = true;
        }

        // Single-argument constructor chaining via this(...)
        public LibraryBook(String title) {
            this(title, "PENDING");
        }

        public void printDetails() {
            System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
        }
    }

    public class LibraryBookCatalog {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of books in the batch: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            LibraryBook[] books = new LibraryBook[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\nBook " + (i + 1) + ":");
                System.out.print("Enter title: ");
                String title = scanner.nextLine().trim();

                System.out.print("Enter ISBN (press Enter if not confirmed yet): ");
                String isbn = scanner.nextLine().trim();

                if (isbn.isEmpty()) {
                    books[i] = new LibraryBook(title);
                } else {
                    books[i] = new LibraryBook(title, isbn);
                }
            }

            System.out.println("\n--- Cataloguing Report ---");
            for (LibraryBook book : books) {
                book.printDetails();
            }

            scanner.close();
        }
    }
}
