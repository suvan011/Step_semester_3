import java.time.*;
import java.util.*;

abstract class Room {
    String id;
    double rate;
    Room(String id, double rate) { this.id = id; this.rate = rate; }
    double calculatePrice(LocalDate start, LocalDate end) { return rate * java.time.temporal.ChronoUnit.DAYS.between(start, end); }
}
class StandardRoom extends Room { StandardRoom(String id) { super(id, 100); } }
class DeluxeRoom extends Room { DeluxeRoom(String id) { super(id, 180); } }
class Customer { String name; Customer(String name) { this.name = name; } }
class Reservation {
    Room room; Customer customer; LocalDate start, end; boolean active = true;
    static List<Reservation> all = new ArrayList<>();
    Reservation(Room room, Customer customer, LocalDate start, LocalDate end) { this.room=room; this.customer=customer; this.start=start; this.end=end; }
    static boolean available(Room room, LocalDate start, LocalDate end) {
        for (Reservation r : all)
            if (r.active && r.room.id.equals(room.id) && start.isBefore(r.end) && end.isAfter(r.start)) return false;
        return true;
    }
    static Reservation book(Room room, Customer c, LocalDate start, LocalDate end) {
        if (!available(room, start, end)) { System.out.println(room.id + " is not available for these dates."); return null; }
        Reservation r = new Reservation(room,c,start,end); all.add(r);
        System.out.println("Reservation confirmed for " + c.name + ", " + room.id + ". Price: $" + room.calculatePrice(start,end));
        return r;
    }
    void cancel(LocalDate today, LocalDate deadline) {
        if (active && today.isBefore(deadline)) { active=false; System.out.println("Reservation cancelled successfully."); }
        else System.out.println("Cancellation deadline has passed.");
    }
}
class RoomDemo {
    public static void main(String[] args) {
        Room room = new StandardRoom("Standard Room 101");
        LocalDate s=LocalDate.of(2026,1,1), e=LocalDate.of(2026,1,5);
        Reservation r=Reservation.book(room,new Customer("Customer A"),s,e);
        Reservation.book(room,new Customer("Customer B"),LocalDate.of(2026,1,3),LocalDate.of(2026,1,7));
        if(r!=null) r.cancel(LocalDate.of(2025,12,20),LocalDate.of(2025,12,25));
    }
}