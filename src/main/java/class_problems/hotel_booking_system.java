package class_problems;
import java.util.*;

interface Room {
    String getRoomNumber();
    double calculatePrice(int days);
}

class StandardRoom implements Room {
    private String roomNumber;

    StandardRoom(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom implements Room {
    private String roomNumber;

    DeluxeRoom(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(int days) {
        return days * 200;
    }
}

class Suite implements Room {
    private String roomNumber;

    Suite(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(int days) {
        return days * 300;
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

class Reservation {
    private Customer customer;
    private Room room;
    private String startDate;
    private String endDate;
    private int days;
    private boolean active;

    Reservation(Customer customer, Room room,
                String startDate, String endDate, int days) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        active = true;
    }

    public boolean isActive() {
        return active;
    }

    public double getPrice() {
        return room.calculatePrice(days);
    }

    public void cancel() {
        active = false;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }
}

class Hotel {
    private ArrayList<Reservation> reservations;

    Hotel() {
        reservations = new ArrayList<>();
    }

    public boolean isAvailable(Room room) {
        for (Reservation reservation : reservations) {
            if (reservation.isActive() &&
                    reservation.getRoom().getRoomNumber()
                            .equals(room.getRoomNumber())) {
                return false;
            }
        }

        return true;
    }

    public void reserve(Customer customer, Room room,
                        String startDate, String endDate, int days) {

        if (!isAvailable(room)) {
            System.out.println(room.getClass().getSimpleName() +
                    " " + room.getRoomNumber() +
                    " is not available.");
            return;
        }

        Reservation reservation =
                new Reservation(customer, room,
                        startDate, endDate, days);

        reservations.add(reservation);

        System.out.println("Reservation confirmed for " +
                customer.getName() + ", " +
                room.getClass().getSimpleName() +
                " " + room.getRoomNumber() +
                " (" + startDate + "-" + endDate + ").");

        System.out.printf("Price: $%.2f%n",
                reservation.getPrice());
    }

    public void cancel(String roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.isActive() &&
                    reservation.getRoom().getRoomNumber()
                            .equals(roomNumber)) {

                reservation.cancel();

                System.out.println(
                        "Reservation for " +
                                reservation.getCustomer().getName() +
                                ", " +
                                roomNumber +
                                " (" +
                                reservation.getStartDate() +
                                "-" +
                                reservation.getEndDate() +
                                ") cancelled successfully.");

                return;
            }
        }

        System.out.println("No active reservation found.");
    }
}

public class Main {
    public static Room createRoom(String type, String number) {
        if (type.equalsIgnoreCase("Standard")) {
            return new StandardRoom(number);
        } else if (type.equalsIgnoreCase("Deluxe")) {
            return new DeluxeRoom(number);
        } else {
            return new Suite(number);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter room type (Standard/Deluxe/Suite): ");
        String type = sc.nextLine();

        System.out.print("Enter room number: ");
        String roomNumber = sc.nextLine();

        System.out.print("Enter start date: ");
        String startDate = sc.nextLine();

        System.out.print("Enter end date: ");
        String endDate = sc.nextLine();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();
        sc.nextLine();

        Customer customer = new Customer(name);
        Room room = createRoom(type, roomNumber);

        if (hotel.isAvailable(room)) {
            System.out.println(room.getClass().getSimpleName() +
                    " " + roomNumber +
                    " is available.");
        } else {
            System.out.println(room.getClass().getSimpleName() +
                    " " + roomNumber +
                    " is not available.");
        }

        hotel.reserve(customer, room, startDate, endDate, days);

        System.out.print("\nEnter second customer name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter start date: ");
        String startDate2 = sc.nextLine();

        System.out.print("Enter end date: ");
        String endDate2 = sc.nextLine();

        System.out.print("Enter number of days: ");
        int days2 = sc.nextInt();
        sc.nextLine();

        Customer customer2 = new Customer(name2);

        hotel.reserve(customer2, room,
                startDate2, endDate2, days2);

        System.out.print("\nEnter room number to cancel: ");
        String cancelRoom = sc.nextLine();

        hotel.cancel(cancelRoom);

        sc.close();
    }
}
