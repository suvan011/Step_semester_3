package week6.assigment_problems;

import java.util.Arrays;

public class PremiumLoyaltyLateFeeLedger {
    static class GymMember {
        private int[] lateFeeHistory = new int[10];
        private int feeCount;
        GymMember(String id, int fee) { if (id == null || id.trim().length() < 4 || fee <= 0) throw new IllegalArgumentException("Invalid member"); }
        protected void chargeLateFee(int amount) { if (feeCount < 10) lateFeeHistory[feeCount++] = amount; }
        int[] getLateFeeHistory() { return Arrays.copyOf(lateFeeHistory, feeCount); }
        int getTotalLateFees() { int total = 0; for (int i = 0; i < feeCount; i++) total += lateFeeHistory[i]; return total; }
    }
    static class PremiumMember extends GymMember {
        PremiumMember(String id, int fee, String trainer) { super(id, fee); }
        @Override protected void chargeLateFee(int amount) { super.chargeLateFee(amount / 2); }
    }
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        int[] history = p.getLateFeeHistory();
        history[0] = 999;
        System.out.println(p.getTotalLateFees());
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}
