package week6.assigment_problems;

public class GymMembershipFoundation {
    static class GymMember {
        protected String memberId;
        protected int monthlyFee;
        private int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) throw new IllegalArgumentException("Invalid memberId");
            if (monthlyFee <= 0) throw new IllegalArgumentException("monthlyFee must be positive");
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }
        public void attendSession() { sessionsAttended++; }
        public int getSessionsAttended() { return sessionsAttended; }
        public void displayInfo() { System.out.println("Standard Member | Sessions: " + sessionsAttended); }
    }

    static class PremiumMember extends GymMember {
        private String trainerName;
        public PremiumMember(String memberId, int monthlyFee, String trainerName) { super(memberId, monthlyFee); this.trainerName = trainerName; }
        public String getTrainerName() { return trainerName; }
        @Override public void displayInfo() { System.out.println("Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended()); }
    }

    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0, rejected = 0;
        for (String id : memberIds) {
            try { new GymMember(id, monthlyFee); signedUp++; }
            catch (IllegalArgumentException e) { rejected++; }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession(); p.attendSession();
        System.out.println(p.getSessionsAttended());
        System.out.println(signUpBatch(new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"}, 1000));
    }
}
