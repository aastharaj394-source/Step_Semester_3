package assignment_problem;
import java.util.Scanner;

abstract class GardenTool {
    public GardenTool() {
    }

    public abstract String use();
}

class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    public String use() {
        return superUse() + ", blade sharpened first";
    }

    private String superUse() {
        return "Using the tool in the garden";
    }
}

class Pruner extends CuttingTool {
    public Pruner() {
        super();
    }

    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1 for CuttingTool or 2 for Pruner: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            CuttingTool c = new CuttingTool();
            System.out.println(c.use());
        } else if (choice == 2) {
            Pruner p = new Pruner();
            System.out.println(p.use());
        } else {
            System.out.println("Invalid choice");
        }
    }
}
