package class_problems;
import java.util.Scanner;
public class Package_Drop_Off_Log {
    abstract class DeliveryNote {
        protected String trackingId;

        public DeliveryNote(String trackingId) {
            this.trackingId = trackingId;
        }

        public abstract String confirmDelivery();

        public String confirmDelivery(String signature) {
            return confirmDelivery() + ", signed by " + signature;
        }
    }

    class ParcelNote extends DeliveryNote {
        public ParcelNote(String trackingId) {
            super(trackingId);
        }

        @Override
        public String confirmDelivery() {
            return "Parcel " + trackingId + " delivered";
        }
    }

    class LetterNote extends DeliveryNote {
        public LetterNote(String trackingId) {
            super(trackingId);
        }

        @Override
        public String confirmDelivery() {
            return "Letter " + trackingId + " delivered";
        }
    }

    public class DropOffLogDemo {
        public static void logAll(DeliveryNote[] notes) {
            for (DeliveryNote note : notes) {
                System.out.println(note.confirmDelivery());
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            DeliveryNote[] notes = new DeliveryNote[n];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String trackingId = parts[1].trim();

                if (type.equalsIgnoreCase("Parcel")) {
                    notes[i] = new ParcelNote(trackingId);
                } else {
                    notes[i] = new LetterNote(trackingId);
                }

                if (parts.length > 2 && !parts[2].trim().isEmpty()) {
                    System.out.println(notes[i].confirmDelivery(parts[2].trim()));
                }
            }

            logAll(notes);
            scanner.close();
        }
    }
}
