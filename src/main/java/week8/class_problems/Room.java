import java.time.*;
import java.util.*;

abstract class Room {
    String id;
    Room(String id) { this.id = id; }
    abstract double price(int nights);
}
class StandardRoom extends Room {
    StandardRoom(String id) { super(id); }
    double price(int n) { return n * 100; }
}
class DeluxeRoom extends Room {
    DeluxeRoom(String id) { super(id); }
    double price(int n) { return n * 180; }
}
class Customer {
    String name;
    Customer(String n) { name = n; }
}
class Reservation {
    static final List<Reservation> active = new ArrayList<>();
    Room room; Customer customer; LocalDate start, end; boolean cancelled;
    Reservation(Room r, Customer c, LocalDate s, LocalDate e) { room=r; customer=c; start=s; end=e; }
    static boolean available(Room r, LocalDate s, LocalDate e) {
        for (Reservation x : active)
            if (!x.cancelled && x.room == r && s.isBefore(x.end) && e.isAfter(x.start)) return false;
        return true;
    }
    static Reservation book(Room r, Customer c, LocalDate s, LocalDate e) {
        if (!e.isAfter(s) || !available(r,s,e)) { System.out.println(r.id + " is not available."); return null; }
        Reservation x = new Reservation(r,c,s,e); active.add(x);
        System.out.println("Reservation confirmed for " + c.name + ", " + r.id + ". Price: $" + r.price((int)java.time.temporal.ChronoUnit.DAYS.between(s,e)));
        return x;
    }
    void cancel(LocalDate today, LocalDate deadline) {
        if (!cancelled && !today.isAfter(deadline)) { cancelled=true; System.out.println("Reservation for " + customer.name + ", " + room.id + " cancelled successfully."); }
        else System.out.println("Cancellation deadline passed.");
    }
}
class HotelDemo {
    public static void main(String[] args) {
        Room r = new StandardRoom("Standard Room 101");
        LocalDate s = LocalDate.of(2026,1,1), e = LocalDate.of(2026,1,5);
        System.out.println(r.id + (Reservation.available(r,s,e) ? " is available." : " is not available."));
        Reservation a=Reservation.book(r,new Customer("Customer A"),s,e);
        Reservation.book(r,new Customer("Customer B"),LocalDate.of(2026,1,3),LocalDate.of(2026,1,7));
        if(a!=null) a.cancel(LocalDate.of(2025,12,20),LocalDate.of(2025,12,25));
        Reservation.book(new DeluxeRoom("Deluxe Room 201"),new Customer("Customer C"),LocalDate.of(2026,2,10),LocalDate.of(2026,2,12));
    }
}