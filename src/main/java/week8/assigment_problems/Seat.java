import java.util.*;
import java.time.*;
abstract class Seat {
    String id; Seat(String id){this.id=id;} abstract double getPrice();
}
class RegularSeat extends Seat {RegularSeat(String id){super(id);} double getPrice(){return 150;}}
class PremiumSeat extends Seat {PremiumSeat(String id){super(id);} double getPrice(){return 250;}}
class ReclinerSeat extends Seat {ReclinerSeat(String id){super(id);} double getPrice(){return 400;}}
class MovieCustomer {String name; MovieCustomer(String n){name=n;}}
class Show {
    String time; LocalDateTime startsAt; Set<String> booked=new HashSet<>();
    Show(String time,LocalDateTime startsAt){this.time=time;this.startsAt=startsAt;}
}
class Booking {
    MovieCustomer customer; Show show; List<Seat> seats=new ArrayList<>(); boolean active=true;
    Booking(MovieCustomer c,Show s,List<Seat> chosen){
        customer=c;show=s;
        if(chosen.isEmpty()||chosen.size()>6){System.out.println("Booking must contain 1 to 6 seats.");return;}
        for(Seat seat:chosen)if(show.booked.contains(seat.id)){System.out.println("Seat "+seat.id+" is already booked for this show.");return;}
        seats.addAll(chosen);for(Seat seat:seats)show.booked.add(seat.id);
        double total=0;for(Seat seat:seats)total+=seat.getPrice();
        System.out.println("Booking confirmed for "+c.name+": "+String.join(", ",seatIds())+". Total: ₹"+String.format("%.2f",total));
    }
    List<String> seatIds(){List<String> ids=new ArrayList<>();for(Seat s:seats)ids.add(s.id);return ids;}
    void cancel(LocalDateTime now){if(active&&now.isBefore(show.startsAt)){active=false;for(Seat s:seats)show.booked.remove(s.id);System.out.println(customer.name+"'s booking cancelled. Seats "+String.join(", ",seatIds())+" released.");}else System.out.println("Cannot cancel after the show starts.");}
}
class SeatDemo {
    public static void main(String[] args){
        Show s=new Show("7 PM",LocalDateTime.of(2026,12,1,19,0));
        Booking b=new Booking(new MovieCustomer("Asha"),s,Arrays.asList(new RegularSeat("A1"),new RegularSeat("A2"),new PremiumSeat("F5")));
        new Booking(new MovieCustomer("Ravi"),s,Arrays.asList(new RegularSeat("A2")));
        new Booking(new MovieCustomer("Ravi"),s,Arrays.asList(new ReclinerSeat("R1")));
        b.cancel(LocalDateTime.of(2026,12,1,18,0));
        new Booking(new MovieCustomer("Neha"),s,Arrays.asList(new RegularSeat("A2")));
    }
}