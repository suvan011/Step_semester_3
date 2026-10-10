import java.util.*;

public class PayrollRegisterSystem {
    static class Payslip {
        String name,type; long pay;
        Payslip(String n,String t,long p){name=n;type=t;pay=p;}
        public String toString(){return "Payslip[name="+name+", type="+type+", pay="+pay+"]";}
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); List<Payslip> slips=new ArrayList<>();
        while(sc.hasNextLine()){
            String line=sc.nextLine().trim(); if(line.isEmpty()) continue;
            String[] p=line.split("\\s+");
            switch(p[0]){
                case "FullTime": slips.add(new Payslip(p[1],p[0],Long.parseLong(p[2]))); break;
                case "PartTime": slips.add(new Payslip(p[1],p[0],Long.parseLong(p[2])*Long.parseLong(p[3]))); break;
                case "Intern": slips.add(new Payslip(p[1],p[0],Long.parseLong(p[2]))); break;
            }
        }
        long total=0; Payslip top=null;
        for(Payslip s:slips){System.out.println(s);total+=s.pay;if(top==null||s.pay>top.pay)top=s;}
        System.out.println("Total "+total);
        if(top!=null) System.out.println("top earner "+top.name);
    }
}