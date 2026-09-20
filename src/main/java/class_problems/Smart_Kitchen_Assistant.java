package class_problems;
import java.util.Scanner;
public class Smart_Kitchen_Assistant {
    interface Washable {
        String clean();
    }

    abstract class KitchenTool {
        private int speedLevel = 1;

        public abstract String prepare();

        public int getSpeedLevel() {
            return speedLevel;
        }

        public void setSpeedLevel(int speedLevel) {
            if (speedLevel >= 1 && speedLevel <= 5) {
                this.speedLevel = speedLevel;
            }
        }
    }

    class Blender extends KitchenTool implements Washable {
        @Override
        public String prepare() {
            return "Blending at speed " + getSpeedLevel();
        }

        @Override
        public String clean() {
            return "Blender rinsed and dried";
        }
    }

    public class KitchenAssistantDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Blender blender = new Blender();

            int operations = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < operations; i++) {
                String command = scanner.nextLine().trim();
                if (command.startsWith("speed")) {
                    int speed = Integer.parseInt(command.split(" ")[1]);
                    blender.setSpeedLevel(speed);
                    System.out.println(blender.getSpeedLevel());
                } else if (command.equalsIgnoreCase("prepare")) {
                    System.out.println(blender.prepare());
                } else if (command.equalsIgnoreCase("clean")) {
                    System.out.println(blender.clean());
                }
            }

            scanner.close();
        }
    }
}
