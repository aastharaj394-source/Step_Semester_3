package assignment_problems;
import java.util.*;

interface Seat {
    String getId();
    double getPrice();
    String getCategory();
}

class RegularSeat implements Seat {
    private String id;

    RegularSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 150;
    }

    public String getCategory() {
        return "Regular";
    }
}

class PremiumSeat implements Seat {
    private String id;

    PremiumSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 250;
    }

    public String getCategory() {
        return "Premium";
    }
}

class ReclinerSeat implements Seat {
    private String id;

    ReclinerSeat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return 400;
    }

    public String getCategory() {
        return "Recliner";
    }
}

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Show {
    private String showTime;
    private HashSet<String> bookedSeats;

    Show(String showTime) {
        this.showTime = showTime;
        bookedSeats = new HashSet<>();
    }

    public boolean isAvailable(String seatId) {
        return !bookedSeats.contains(seatId);
    }

    public boolean bookSeat(String seatId) {
        if (!isAvailable(seatId)) {
            return false;
        }

        bookedSeats.add(seatId);
        return true;
    }

    public void releaseSeat(String seatId) {
        bookedSeats.remove(seatId);
    }

    public String getShowTime() {
        return showTime;
    }
}

class Booking {
    private Customer customer;
    private Show show;
    private ArrayList<Seat> seats;
    private boolean cancelled;

    Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>();
        this.cancelled = false;
    }

    public boolean addSeat(Seat seat) {
        if (seats.size() >= 6) {
            System.out.println("Maximum 6 seats allowed per booking.");
            return false;
        }

        if (!show.bookSeat(seat.getId())) {
            System.out.println("Seat " + seat.getId() +
                    " is already booked for this show.");
            return false;
        }

        seats.add(seat);
        return true;
    }

    public double calculateTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    public void confirm() {
        System.out.print("Booking confirmed for " +
                customer.getName() + ": ");

        for (int i = 0; i < seats.size(); i++) {
            System.out.print(seats.get(i).getId());

            if (i < seats.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.printf(". Total: ₹%.2f%n", calculateTotal());
    }

    public void cancel(boolean showStarted) {
        if (cancelled) {
            System.out.println("Booking is already cancelled.");
            return;
        }

        if (showStarted) {
            System.out.println("Cannot cancel booking after show starts.");
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat.getId());
        }

        cancelled = true;

        System.out.println(customer.getName() + "'s booking cancelled.");

        System.out.print("Seats ");

        for (int i = 0; i < seats.size(); i++) {
            System.out.print(seats.get(i).getId());

            if (i < seats.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" released.");
    }
}

public class Main {
    public static Seat createSeat(String category, String id) {
        if (category.equalsIgnoreCase("Regular")) {
            return new RegularSeat(id);
        } else if (category.equalsIgnoreCase("Premium")) {
            return new PremiumSeat(id);
        } else {
            return new ReclinerSeat(id);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Show show = new Show("7 PM");

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        Customer customer = new Customer(name);
        Booking booking = new Booking(customer, show);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat ID: ");
            String id = sc.nextLine();

            System.out.print("Enter category (Regular/Premium/Recliner): ");
            String category = sc.nextLine();

            Seat seat = createSeat(category, id);
            booking.addSeat(seat);
        }

        booking.confirm();

        System.out.print("Do you want to cancel the booking? (yes/no): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Has the show started? (yes/no): ");
            String started = sc.nextLine();

            boolean showStarted = started.equalsIgnoreCase("yes");
            booking.cancel(showStarted);
        }

        sc.close();
    }
}
