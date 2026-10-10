import java.util.*;
abstract class Seat {
    String id; Seat(String id){this.id=id;}
    abstract double price();
}
class RegularSeat extends Seat { RegularSeat(String id){super(id);} double price(){return 150;} }
class PremiumSeat extends Seat { PremiumSeat(String id){super(id);} double price(){return 250;} }
class ReclinerSeat extends Seat { ReclinerSeat(String id){super(id);} double price(){return 400;} }
class Show {
    String time; Set<String> booked=new HashSet<>();
    Show(String time){this.time=time;}
    boolean book(String customer, Seat... seats) {
        if(seats.length==0 || seats.length>6){System.out.println("A booking must contain 1 to 6 seats.");return false;}
        for(Seat s:seats) if(booked.contains(s.id)){System.out.println("Seat "+s.id+" is already booked for this show.");return false;}
        double total=0; for(Seat s:seats){booked.add(s.id);total+=s.price();}
        System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.%n",customer,java.util.Arrays.stream(seats).map(s->s.id).toList(),total);
        return true;
    }
    void release(Seat... seats){for(Seat s:seats)booked.remove(s.id);}
}
class Booking {
    String customer; Show show; Seat[] seats; boolean cancelled;
    Booking(String c,Show s,Seat... seats){customer=c;show=s;this.seats=seats;}
    void cancel(boolean beforeShow){if(!cancelled&&beforeShow){show.release(seats);cancelled=true;System.out.println(customer+"'s booking cancelled. Seats released.");}else System.out.println("Cannot cancel after the show starts.");}
}
class TicketDemo {
    public static void main(String[] args) {
        Show s=new Show("7 PM"); Seat a1=new RegularSeat("A1"),a2=new RegularSeat("A2"),f5=new PremiumSeat("F5"),r1=new ReclinerSeat("R1");
        s.book("Asha",a1,a2,f5);s.book("Ravi",a2);s.book("Ravi",r1);
        new Booking("Asha",s,a1,a2,f5).cancel(true);s.book("Neha",a2);
    }
}