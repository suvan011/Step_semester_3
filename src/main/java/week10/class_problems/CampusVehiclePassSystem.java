import java.util.*;

public class CampusVehiclePassSystem {
    interface Chargeable { boolean bookBay(); }
    static abstract class Vehicle {
        String pass, owner;
        Vehicle(String p, String o) { pass=p; owner=o; }
        abstract int fee();
        String type() { return getClass().getSimpleName(); }
    }
    static class Bike extends Vehicle { Bike(String p,String o){super(p,o);} int fee(){return 300;} }
    static class Car extends Vehicle { Car(String p,String o){super(p,o);} int fee(){return 1000;} }
    static class EBike extends Vehicle implements Chargeable {
        EBike(String p,String o){super(p,o);} int fee(){return 300;}
        public boolean bookBay(){return true;}
    }
    static class ECar extends Vehicle implements Chargeable {
        ECar(String p,String o){super(p,o);} int fee(){return 1000;}
        public boolean bookBay(){return true;}
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); Map<String,Vehicle> vehicles=new HashMap<>();
        while(sc.hasNextLine()){
            String line=sc.nextLine().trim(); if(line.isEmpty()) continue;
            String[] p=line.split("\\s+");
            if(p[0].equals("PASS")){
                Vehicle v;
                switch(p[1]){
                    case "Bike": v=new Bike(p[2],p[3]); break;
                    case "Car": v=new Car(p[2],p[3]); break;
                    case "EBike": v=new EBike(p[2],p[3]); break;
                    case "ECar": v=new ECar(p[2],p[3]); break;
                    default: continue;
                }
                vehicles.put(v.pass,v);
                System.out.println(v.pass+" ("+v.type()+") pass fee "+v.fee());
            } else if(p[0].equals("CHARGE")){
                Vehicle v=vehicles.get(p[1]);
                if(v instanceof Chargeable && ((Chargeable)v).bookBay())
                    System.out.println(p[1]+" charging bay allotted");
                else System.out.println(p[1]+" rejected: charging unsupported");
            }
        }
    }
}