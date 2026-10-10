interface MembershipPlan {String name(); int months(); double discount();}
class MonthlyPlan implements MembershipPlan {public String name(){return "Monthly";}public int months(){return 1;}public double discount(){return 0;}}
class QuarterlyPlan implements MembershipPlan {public String name(){return "Quarterly";}public int months(){return 3;}public double discount(){return .10;}}
class AnnualPlan implements MembershipPlan {public String name(){return "Annual";}public int months(){return 12;}public double discount(){return .25;}}
class GymMembership {
    private final String member; private final MembershipPlan plan; private String status="Active";
    GymMembership(String member,MembershipPlan plan){this.member=member;this.plan=plan;double fee=1000*plan.months()*(1-plan.discount());System.out.println(plan.name()+" membership created for "+member+". Fee: ₹"+String.format("%.2f",fee)+". Status: "+status+".");}
    void checkIn(){if(status.equals("Active"))System.out.println(member+" checked in successfully.");else System.out.println("Check-in denied: "+member+"'s membership is "+status+".");}
    void freeze(){if(status.equals("Active")){status="Frozen";System.out.println(member+"'s membership frozen. Status: "+status+".");}else System.out.println("Cannot freeze a "+status+" membership.");}
    void unfreeze(){if(status.equals("Frozen")){status="Active";System.out.println(member+"'s membership unfrozen.");}else System.out.println("Cannot unfreeze a "+status+" membership.");}
    void expire(){status="Expired";System.out.println(member+"'s membership expired. Status: "+status+".");}
}
class MembershipDemo {
    public static void main(String[] args){
        GymMembership a=new GymMembership("Asha",new QuarterlyPlan()),r=new GymMembership("Ravi",new MonthlyPlan());
        a.checkIn();a.freeze();a.checkIn();r.expire();r.freeze();
    }
}