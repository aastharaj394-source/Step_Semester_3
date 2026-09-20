package assignment_problem;
import java.util.Scanner;
public class Parking_overstay_fine_calculator {
    class ParkingTicket {
        String vehicleNo;
        double ratePerMinute;

        public ParkingTicket(String vehicleNo, double ratePerMinute) {
            this.vehicleNo = vehicleNo;
            this.ratePerMinute = ratePerMinute;
        }

        public final double calculateFine(int overstayMinutes) {
            return overstayMinutes * ratePerMinute;
        }

        public final void printReceipt(int overstayMinutes) {
            double fine = calculateFine(overstayMinutes);
            System.out.println(vehicleNo + " - Fine: Rs " + fine);
        }
    }

    public class ParkingFineCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of vehicles: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            String[] vehicleNos = new String[n];
            double[] rates = new double[n];
            int[] overstayMinutes = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter vehicle number: ");
                vehicleNos[i] = scanner.nextLine().trim();

                System.out.print("Enter rate per minute: ");
                rates[i] = Double.parseDouble(scanner.nextLine().trim());

                System.out.print("Enter overstay minutes: ");
                overstayMinutes[i] = Integer.parseInt(scanner.nextLine().trim());
            }

            System.out.println();
            for (int i = 0; i < n; i++) {
                ParkingTicket ticket = new ParkingTicket(vehicleNos[i], rates[i]);
                if (overstayMinutes[i] > 0) {
                    ticket.printReceipt(overstayMinutes[i]);
                } else {
                    System.out.println(vehicleNos[i] + " - No fine, within allotted time");
                }
            }

            scanner.close();
        }
    }
}
