package week6.class_problems;

import java.util.Arrays;

public class StudentDiscountFineLedger {
    static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        private int[] fineHistory = new int[10];
        private int fineCount;

        LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4 || borrowLimit <= 0)
                throw new IllegalArgumentException("Invalid member");
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        protected void chargeFine(int amount) {
            if (fineCount < fineHistory.length) fineHistory[fineCount++] = amount;
        }

        public int[] getFineHistory() { return Arrays.copyOf(fineHistory, fineCount); }
        public int getTotalFine() {
            int total = 0;
            for (int i = 0; i < fineCount; i++) total += fineHistory[i];
            return total;
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;
        StudentMember(String memberId, int borrowLimit, String course) { super(memberId, borrowLimit); this.course = course; }

        @Override
        protected void chargeFine(int amount) { super.chargeFine(amount / 2); }
    }

    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        int[] history = s.getFineHistory();
        history[0] = 999;
        System.out.println(s.getTotalFine());
        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}
