package week6.assigment_problems;

public class MembershipNumbersReferralSettlement {
    static class GymMember {
        private static int membersEnrolled;
        private final String membershipNumber;
        private int monthlyFee;
        private int feesPaid;
        GymMember(int monthlyFee) {
            if (monthlyFee <= 0) throw new IllegalArgumentException("monthlyFee must be positive");
            membersEnrolled++;
            membershipNumber = "GYM-" + (2000 + membersEnrolled);
            this.monthlyFee = monthlyFee;
        }
        void payFee(int amount) { if (amount > 0) feesPaid += amount; }
        void payFee(int amount, String mode) { payFee(amount); }
        int getFeesPaid() { return feesPaid; }
        String getMembershipNumber() { return membershipNumber; }
        static boolean isValidReferralCode(String code) {
            if (code == null || code.length() != 4) return false;
            return code.charAt(0) == 'G' && Character.isDigit(code.charAt(1))
                    && Character.isDigit(code.charAt(2)) && Character.isUpperCase(code.charAt(3));
        }
        static int getMembersEnrolled() { return membersEnrolled; }
    }

    static class GroupClassMember extends GymMember {
        private String className;
        GroupClassMember(int monthlyFee, String className) { super(monthlyFee); this.className = className; }
    }

    static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0, skipped = 0, group = 0, individual = 0;
        for (GymMember member : members) {
            if (member == null) { skipped++; continue; }
            processed++;
            if (member instanceof GroupClassMember) group++; else individual++;
        }
        return processed + " processed | " + skipped + " null skipped | " + group + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getMembershipNumber());
        System.out.println(GymMember.getMembersEnrolled());
        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(m1.getFeesPaid());
        System.out.println(processWeeklyCheckIn(new GymMember[]{new GroupClassMember(1500, "Zumba"), null, new GymMember(1000)}));
    }
}
