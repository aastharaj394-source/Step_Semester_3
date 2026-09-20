package Class_problem;
import java.util.Scanner;
public class Movie_booking_OTP_property {
    public class MovieBookingProfile {
        private String name;
        private boolean confirmed;
        private String otp;

        public MovieBookingProfile() {
        }

        public MovieBookingProfile(String name) {
            this();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isConfirmed() {
            return confirmed;
        }

        public void setConfirmed(boolean confirmed) {
            this.confirmed = confirmed;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine().trim();
            MovieBookingProfile profile = new MovieBookingProfile(name);

            boolean status = Boolean.parseBoolean(scanner.nextLine().trim());
            profile.setConfirmed(status);

            String otp = scanner.nextLine().trim();
            profile.setOtp(otp);

            System.out.println(profile.getName());
            System.out.println(profile.isConfirmed());

            scanner.close();
        }
    }
}
