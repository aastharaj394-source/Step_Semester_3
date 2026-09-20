package session_one_topics.assignment_problems;
import java.util.Scanner;
public class Warehouse_Inventory_Balance {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }
        System.out.println("\n--- Warehouse Inventory Analysis Report ---");
        System.out.println("Total Quantity in Section A : " + totalA);
        System.out.println("Total Quantity in Section B : " + totalB);
        if (totalA == totalB) {
            System.out.println("Inventory Balance Status    : Balanced (Both sections hold identical total quantities)");
        } else {
            System.out.println("Inventory Balance Status    : Not Balanced (Discrepancy of " + Math.abs(totalA - totalB) + " units detected)");
        }

        System.out.println("Highest Stock Item Quantity : " + maxQuantity + " units (Located in " + maxSection + " at Category/Index " + maxIndex + ")");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of product categories: ");
        int n = scanner.nextInt();
        int[] sectionA = new int[n];
        int[] sectionB = new int[n];
        System.out.println("\nEnter item quantities for Section A:");
        for (int i = 0; i < n; i++) {
            System.out.print("Section A [Category " + i + "]: ");
            sectionA[i] = scanner.nextInt();
        }
        System.out.println("\nEnter item quantities for Section B:");
        for (int i = 0; i < n; i++) {
            System.out.print("Section B [Category " + i + "]: ");
            sectionB[i] = scanner.nextInt();
        }
        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
}
