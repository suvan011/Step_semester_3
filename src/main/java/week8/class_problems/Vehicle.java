abstract class Vehicle {
    private final String id;
    private boolean available = true;

    Vehicle(String id) { this.id = id; }
    String getId() { return id; }
    boolean isAvailable() { return available; }
    void setAvailable(boolean value) { available = value; }
    abstract double charge(int days);
}
class Sedan extends Vehicle {
    Sedan(String id) { super(id); }
    double charge(int days) { return days * 50.0; }
}
class SUV extends Vehicle {
    SUV(String id) { super(id); }
    double charge(int days) { return days * 80.0; }
}
class Customer {
    String name;
    Customer(String name) { this.name = name; }
}
class Rental {
    static void rent(Vehicle v, Customer c, int days) {
        if (!v.isAvailable()) {
            System.out.println(v.getId() + " is currently unavailable.");
            return;
        }
        v.setAvailable(false);
        System.out.println(v.getId() + " rented successfully by " + c.name
                + ". Rental charge: $" + v.charge(days));
    }
    static void returnVehicle(Vehicle v, Customer c) {
        v.setAvailable(true);
        System.out.println(v.getId() + " returned by " + c.name + ".");
    }
}
class VehicleDemo {
    public static void main(String[] args) {
        Vehicle sedan = new Sedan("Sedan A"), suv = new SUV("SUV B");
        Customer c1 = new Customer("Customer 1"), c2 = new Customer("Customer 2");
        Rental.rent(sedan, c1, 3);
        Rental.rent(sedan, c2, 2);
        Rental.returnVehicle(sedan, c1);
        Rental.rent(suv, new Customer("Customer 3"), 5);
    }
}