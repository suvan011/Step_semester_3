import java.util.*;

interface WashType { int duration(); double charge(); String name(); }
class QuickWash implements WashType { public int duration(){return 30;} public double charge(){return 20;} public String name(){return "Quick";} }
class NormalWash implements WashType { public int duration(){return 45;} public double charge(){return 30;} public String name(){return "Normal";} }
class HeavyWash implements WashType { public int duration(){return 60;} public double charge(){return 45;} public String name(){return "Heavy";} }
class WashingMachine {
    private final String id; private boolean busy=false;
    WashingMachine(String id){this.id=id;}
    boolean start(String student, WashType type){
        if(busy){System.out.println("Machine "+id+" is currently busy.");return false;}
        busy=true; System.out.println(type.name()+" wash started on "+id+" for "+student+" ("+type.duration()+" min). Charge: ₹"+String.format("%.2f",type.charge())+"."); return true;
    }
    void complete(){if(busy){busy=false;System.out.println(id+" cycle completed. "+id+" is now free.");}}
}
class LaundryDemo {
    public static void main(String[] args){
        WashingMachine m1=new WashingMachine("M1"),m2=new WashingMachine("M2");
        m1.start("Asha",new QuickWash());m1.start("Ravi",new HeavyWash());m2.start("Ravi",new HeavyWash());m1.complete();m1.start("Neha",new NormalWash());
    }
}