package week6.class_problems;

public class ThreeBranchesOfMembership {
    static class LibraryMember {
        private int booksBorrowed;
        protected String memberId;
        protected int borrowLimit;

        LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4 || borrowLimit <= 0)
                throw new IllegalArgumentException("Invalid member");
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        public void borrowBook() { if (booksBorrowed < borrowLimit) booksBorrowed++; }
        public int getBooksBorrowed() { return booksBorrowed; }
        public void displayInfo() { System.out.println("General Member | Books Borrowed: " + booksBorrowed); }
    }

    static class StudentMember extends LibraryMember {
        protected String course;
        StudentMember(String memberId, int borrowLimit, String course) { super(memberId, borrowLimit); this.course = course; }
        public void displayInfo() { System.out.println("Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed()); }
    }

    static class HonorsStudentMember extends StudentMember {
        private int bonusLimit;
        HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
            super(memberId, borrowLimit, course); this.bonusLimit = bonusLimit;
        }
        public void displayInfo() { System.out.println("Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed()); }
    }

    static class FacultyMember extends LibraryMember {
        private String department;
        FacultyMember(String memberId, int borrowLimit, String department) { super(memberId, borrowLimit); this.department = department; }
        public void displayInfo() { System.out.println("Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed()); }
    }

    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) return "Multilevel descendant (3 generations deep)";
        if (member instanceof FacultyMember) return "Hierarchical sibling (independent branch)";
        if (member instanceof StudentMember) return "Direct subclass (2 generations deep)";
        return "Base member";
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember member : members) total += member.getBooksBorrowed();
        return total;
    }

    public static void main(String[] args) {
        StudentMember student = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember honors = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("STU4", 5, "Physics");
        student.borrowBook(); student.borrowBook();
        honors.borrowBook();
        faculty.borrowBook(); faculty.borrowBook(); faculty.borrowBook();
        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));
        System.out.println(getTotalBooksBorrowed(new LibraryMember[]{student, honors, faculty}));
    }
}
