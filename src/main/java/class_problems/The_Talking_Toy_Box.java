package class_problems;
import java.util.Scanner;
public class The_Talking_Toy_Box {
    abstract class Toy {
        private static int counter = 1000;
        private final String toyId;
        protected String name;

        public Toy(String name) {
            counter++;
            this.toyId = "TOY-" + counter;
            this.name = name;
        }

        public String getToyId() {
            return toyId;
        }

        public abstract String makeSound();
    }

    class ToyCar extends Toy {
        public ToyCar(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    class ToyRobot extends Toy {
        public ToyRobot(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Beep boop!";
        }
    }

    public class ToyBoxDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            Toy[] toys = new Toy[n];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String name = parts[1].trim();

                if (type.equalsIgnoreCase("Car")) {
                    toys[i] = new ToyCar(name);
                } else {
                    toys[i] = new ToyRobot(name);
                }
            }

            for (Toy t : toys) {
                System.out.println(t.getToyId());
                System.out.println(t.makeSound());
            }

            scanner.close();
        }
    }
}
