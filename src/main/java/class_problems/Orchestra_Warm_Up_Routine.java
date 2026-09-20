package class_problems;
import java.util.Scanner;
public class Orchestra_Warm_Up_Routine {
    abstract class Instrument {
        public abstract String play();
    }

    class StringInstrument extends Instrument {
        public StringInstrument() {
            super();
        }

        @Override
        public String play() {
            return "Strumming the strings";
        }
    }

    class Violin extends StringInstrument {
        public Violin() {
            super();
        }

        @Override
        public String play() {
            return super.play() + ", with a bow drawn across four strings";
        }
    }

    public class OrchestraDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine().trim());

            if (choice == 1) {
                StringInstrument s = new StringInstrument();
                System.out.println(s.play());
            } else if (choice == 2) {
                Violin v = new Violin();
                System.out.println(v.play());
            }

            scanner.close();
        }
    }
}
