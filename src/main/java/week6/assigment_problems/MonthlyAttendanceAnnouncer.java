package week6.assigment_problems;

public class MonthlyAttendanceAnnouncer {
    static class GymMember {
        private int sessions;
        GymMember(String id, int fee) { if (id == null || id.trim().length() < 4 || fee <= 0) throw new IllegalArgumentException("Invalid member"); }
        void attendSession() { sessions++; }
        int getSessionsAttended() { return sessions; }
        void displayInfo(StringBuilder out) { out.append("Standard | Sessions: ").append(sessions); }
    }
    static class PremiumMember extends GymMember {
        private String trainerName;
        PremiumMember(String id, int fee, String trainer) { super(id, fee); trainerName = trainer; }
        String getTrainerName() { return trainerName; }
        @Override void displayInfo(StringBuilder out) { out.append("Premium | Trainer: ").append(trainerName).append(" | Sessions: ").append(getSessionsAttended()); }
    }
    static String batchPrint(GymMember[] members) {
        StringBuilder announcement = new StringBuilder();
        for (GymMember member : members) {
            member.displayInfo(announcement);
            if (member instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) member;
                announcement.append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
            }
            announcement.append(" | ");
        }
        return announcement.toString();
    }
    public static void main(String[] args) {
        GymMember plain = new GymMember("MEM6", 1000);
        PremiumMember premium = new PremiumMember("MEM7", 2000, "Coach Riya");
        System.out.println(batchPrint(new GymMember[]{plain, premium}));
    }
}
