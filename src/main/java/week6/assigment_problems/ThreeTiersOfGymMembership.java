package week6.assigment_problems;

public class ThreeTiersOfGymMembership {
    static class GymMember {
        private int sessionsAttended;
        GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4 || monthlyFee <= 0) throw new IllegalArgumentException("Invalid member");
        }
        public void attendSession() { sessionsAttended++; }
        public int getSessionsAttended() { return sessionsAttended; }
        public void displayInfo() { System.out.println("Standard Member | Sessions: " + sessionsAttended); }
    }
    static class PremiumMember extends GymMember {
        protected String trainerName;
        PremiumMember(String id, int fee, String trainer) { super(id, fee); trainerName = trainer; }
        public void displayInfo() { System.out.println("Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended()); }
    }
    static class EliteMember extends PremiumMember {
        private String lockerNumber;
        EliteMember(String id, int fee, String trainer, String locker) { super(id, fee, trainer); lockerNumber = locker; }
        public void displayInfo() { System.out.println("Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended()); }
    }
    static class GroupClassMember extends GymMember {
        private String className;
        GroupClassMember(String id, int fee, String className) { super(id, fee); this.className = className; }
        public void displayInfo() { System.out.println("Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended()); }
    }
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) return "Multilevel descendant (3 generations deep)";
        if (member instanceof GroupClassMember) return "Hierarchical sibling (independent branch)";
        if (member instanceof PremiumMember) return "Direct subclass (2 generations deep)";
        return "Base member";
    }
    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember member : members) total += member.getSessionsAttended();
        return total;
    }
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember e = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember g = new GroupClassMember("MEM4", 1500, "Zumba");
        for (int i = 0; i < 3; i++) p.attendSession();
        for (int i = 0; i < 2; i++) e.attendSession();
        for (int i = 0; i < 4; i++) g.attendSession();
        System.out.println(classifyGeneration(e));
        System.out.println(classifyGeneration(g));
        System.out.println(getTotalSessionsAttended(new GymMember[]{p, e, g}));
    }
}
