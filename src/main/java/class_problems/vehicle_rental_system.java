package class_problems;
import java.util.*;

interface Vehicle {
    String getName();
    double calculateCharge(int days);
}

class Sedan implements Vehicle {
    private String name;

    Sedan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV implements Vehicle {
    private String name;

    SUV(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateCharge(int days) {
        return days * 80;
    }
}

class Truck implements Vehicle {
    private String name;

    Truck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateCharge(int days) {
        return days * 100;
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

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private boolean active;

    Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.active = true;
    }

    public double getCharge() {
        return vehicle.calculateCharge(days);
    }

    public void endRental() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class RentalSystem {
    private HashMap<String, Rental> rentals;

    RentalSystem() {
        rentals = new HashMap<>();
    }

    public void rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (rentals.containsKey(vehicle.getName()) &&
                rentals.get(vehicle.getName()).isActive()) {

            System.out.println(vehicle.getName() + " is currently unavailable.");
            return;
        }

        Rental rental = new Rental(customer, vehicle, days);
        rentals.put(vehicle.getName(), rental);

        System.out.println(vehicle.getName() +
                " rented successfully by " +
                customer.getName() + ".");

        System.out.printf("Rental charge: $%.2f%n", rental.getCharge());
    }

    public void returnVehicle(String vehicleName) {
        if (!rentals.containsKey(vehicleName) ||
                !rentals.get(vehicleName).isActive()) {

            System.out.println(vehicleName + " is not currently rented.");
            return;
        }

        Rental rental = rentals.get(vehicleName);
        rental.endRental();

        System.out.println(vehicleName +
                " returned by " +
                rental.getCustomer().getName() + ".");
    }
}

public class Main {
    public static Vehicle createVehicle(String type, String name) {
        if (type.equalsIgnoreCase("Sedan")) {
            return new Sedan(name);
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUV(name);
        } else {
            return new Truck(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RentalSystem system = new RentalSystem();

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter vehicle type (Sedan/SUV/Truck): ");
        String type = sc.nextLine();

        System.out.print("Enter vehicle name: ");
        String vehicleName = sc.nextLine();

        System.out.print("Enter rental duration in days: ");
        int days = sc.nextInt();
        sc.nextLine();

        Customer customer = new Customer(customerName);
        Vehicle vehicle = createVehicle(type, vehicleName);

        system.rentVehicle(customer, vehicle, days);

        System.out.print("Enter second customer name: ");
        String customer2Name = sc.nextLine();

        System.out.print("Enter rental duration in days: ");
        int days2 = sc.nextInt();
        sc.nextLine();

        Customer customer2 = new Customer(customer2Name);

        system.rentVehicle(customer2, vehicle, days2);

        System.out.print("Enter vehicle name to return: ");
        String returnVehicle = sc.nextLine();

        system.returnVehicle(returnVehicle);

        System.out.print("Enter third customer name: ");
        String customer3Name = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type3 = sc.nextLine();

        System.out.print("Enter vehicle name: ");
        String vehicle3Name = sc.nextLine();

        System.out.print("Enter rental duration: ");
        int days3 = sc.nextInt();

        Customer customer3 = new Customer(customer3Name);
        Vehicle vehicle3 = createVehicle(type3, vehicle3Name);

        system.rentVehicle(customer3, vehicle3, days3);

        sc.close();
    }
}