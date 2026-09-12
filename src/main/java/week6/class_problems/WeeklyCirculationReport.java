package week6.class_problems;

public class WeeklyCirculationReport {
    static class LibraryMember {
        private int booksBorrowed;
        LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4 || borrowLimit <= 0) throw new IllegalArgumentException("Invalid member");
        }
        public void borrowBook() { booksBorrowed++; }
        public int getBooksBorrowed() { return booksBorrowed; }
        public void displayInfo(StringBuilder out) { out.append("General | Books: ").append(booksBorrowed); }
    }

    static class StudentMember extends LibraryMember {
        private String course;
        StudentMember(String memberId, int borrowLimit, String course) { super(memberId, borrowLimit); this.course = course; }
        public String getCourse() { return course; }
        @Override public void displayInfo(StringBuilder out) { out.append("Student | Course: ").append(course).append(" | Books: ").append(getBooksBorrowed()); }
    }

    static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();
        for (LibraryMember member : members) {
            member.displayInfo(report);
            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;
                report.append(" [Course via downcast: ").append(student.getCourse()).append("]");
            }
            report.append(" | ");
        }
        return report.toString();
    }

    public static void main(String[] args) {
        LibraryMember general = new LibraryMember("LB5", 3);
        StudentMember student = new StudentMember("STU6", 3, "ECE");
        student.borrowBook();
        System.out.println(batchPrint(new LibraryMember[]{general, student}));
    }
}
