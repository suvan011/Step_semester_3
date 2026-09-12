package week6.class_problems;

public class MembershipNumbersRenewalAudit {
    static class LibraryMember {
        private static int membersEnrolled;
        private final String memberNumber;
        private int borrowLimit;
        private int booksBorrowed;
        private String lastGenre;

        public LibraryMember(int borrowLimit) {
            if (borrowLimit <= 0) throw new IllegalArgumentException("borrowLimit must be positive");
            membersEnrolled++;
            memberNumber = "LIB-" + (100 + membersEnrolled);
            this.borrowLimit = borrowLimit;
        }

        void borrowBook() { if (booksBorrowed < borrowLimit) booksBorrowed++; }
        void borrowBook(String genre) { lastGenre = genre; borrowBook(); }
        int getBooksBorrowed() { return booksBorrowed; }
        String getMemberNumber() { return memberNumber; }
        static boolean isValidRenewalCode(String code) {
            if (code == null || code.length() != 4) return false;
            return code.charAt(0) == 'R'
                    && Character.isDigit(code.charAt(1))
                    && Character.isDigit(code.charAt(2))
                    && Character.isUpperCase(code.charAt(3));
        }
        static int getMembersEnrolled() { return membersEnrolled; }
    }

    static class FacultyMember extends LibraryMember {
        private String department;
        public FacultyMember(int borrowLimit, String department) { super(borrowLimit); this.department = department; }
    }

    static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0, skipped = 0, faculty = 0, regular = 0;
        for (LibraryMember member : members) {
            if (member == null) { skipped++; continue; }
            processed++;
            if (member instanceof FacultyMember) faculty++; else regular++;
        }
        return processed + " processed | " + skipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }

    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getMemberNumber());
        System.out.println(LibraryMember.getMembersEnrolled());
        System.out.println(LibraryMember.isValidRenewalCode("R12A"));
        System.out.println(m1.getBooksBorrowed());
        System.out.println(processNightlyAudit(new LibraryMember[]{new FacultyMember(5, "Physics"), null, new LibraryMember(3)}));
    }
}
