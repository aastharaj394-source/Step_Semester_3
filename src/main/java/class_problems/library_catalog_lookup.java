package class_problems;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class library_catalog_lookup {
    public static class Book {
        String isbn;
        String title;

        public Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    /**
     * Efficiently searches for a book's title given its ISBN using Binary Search.
     *
     * @param catalog    List of Book records, pre-sorted by ISBN in ascending order.
     * @param targetIsbn The ISBN to search for.
     * @return The title if found, or "Not Found" otherwise.
     */
    public static String findBook(List<Book> catalog, String targetIsbn) {
        if (catalog == null || catalog.isEmpty() || targetIsbn == null) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Book midBook = catalog.get(mid);

            // Compare ISBNs lexicographically
            int comparison = midBook.isbn.compareTo(targetIsbn);

            if (comparison == 0) {
                return midBook.title; // Target found
            } else if (comparison < 0) {
                low = mid + 1;        // Target is in the right half
            } else {
                high = mid - 1;       // Target is in the left half
            }
        }

        return "Not Found"; // Target not present in catalog
    }

    public static void main(String[] args) {
        // Sample sorted catalog
        List<Book> catalog = new ArrayList<>();
        catalog.add(new Book("0001112223", "Introduction to Algebra"));
        catalog.add(new Book("0002223334", "Beginning Python"));
        catalog.add(new Book("0003334445", "Classic Mythology"));
        catalog.add(new Book("0004445556", "Data and Society"));
        catalog.add(new Book("0005556667", "European History"));

        // Test Example 1
        String target1 = "0003334445";
        System.out.println("Lookup " + target1 + ": " + findBook(catalog, target1));
        // Output: Classic Mythology

        // Test Example 2
        String target2 = "0009998887";
        System.out.println("Lookup " + target2 + ": " + findBook(catalog, target2));
        // Output: Not Found
    }
}
