interface MembershipPlan { double fee(); }
class MonthlyPlan implements MembershipPlan { public double fee(){return 1000;} }
class QuarterlyPlan implements MembershipPlan { public double fee(){return 1000*3*.90;} }
class AnnualPlan implements MembershipPlan { public double fee(){return 1000*12*.75;} }
class Membership {
    private String status="Active"; private final String member; private final MembershipPlan plan;
    Membership(String member,MembershipPlan plan){this.member=member;this.plan=plan;System.out.printf("%s membership created. Fee: ₹%.2f. Status: %s.%n",plan.getClass().getSimpleName(),plan.fee(),status);}
    void checkIn(){System.out.println(status.equals("Active")?member+" checked in successfully.":"Check-in denied: "+member+"'s membership is "+status+".");}
    void freeze(){if(status.equals("Active")){status="Frozen";System.out.println(member+"'s membership frozen.");}else System.out.println("Cannot freeze a "+status+" membership.");}
    void unfreeze(){if(status.equals("Frozen")){status="Active";System.out.println(member+"'s membership unfrozen.");}else System.out.println("Cannot unfreeze a "+status+" membership.");}
    void expire(){status="Expired";System.out.println(member+"'s membership expired.");}
}
class MembershipDemo {
    public static void main(String[] args){
        Membership a=new Membership("Asha",new QuarterlyPlan()),r=new Membership("Ravi",new MonthlyPlan());
        a.checkIn();a.freeze();a.checkIn();r.expire();r.freeze();
    }
}