import java.time.*;
abstract class Assignment {
    String title; LocalDate due; int maxMarks;
    Assignment(String t, LocalDate d, int m) { title=t; due=d; maxMarks=m; }
    abstract double penaltyPerDay();
    double finalMarks(int marks, LocalDate submitted) {
        long days = Math.max(0, java.time.temporal.ChronoUnit.DAYS.between(due, submitted));
        return Math.max(0, marks * (1 - days * penaltyPerDay()));
    }
}
class CodingAssignment extends Assignment {
    CodingAssignment(String t, LocalDate d, int m) { super(t,d,m); }
    double penaltyPerDay() { return 0.10; }
}
class WrittenAssignment extends Assignment {
    WrittenAssignment(String t, LocalDate d, int m) { super(t,d,m); }
    double penaltyPerDay() { return 0.20; }
}
class Submission {
    private final String student; private final Assignment assignment; private final LocalDate submitted;
    private String status="Submitted"; private boolean graded;
    Submission(String s, Assignment a, LocalDate d) { student=s; assignment=a; submitted=d; }
    void grade(int marks) {
        if(graded){System.out.println("Cannot resubmit: '"+assignment.title+"' has already been graded.");return;}
        graded=true; status="Graded";
        System.out.printf("%s graded: %.0f/%d. Status: %s%n", student, assignment.finalMarks(marks,submitted), assignment.maxMarks,status);
    }
    String getStatus(){return status;}
}
class SubmissionDemo {
    public static void main(String[] args) {
        Assignment coding=new CodingAssignment("Linked List Lab",LocalDate.of(2026,3,10),50);
        Assignment written=new WrittenAssignment("Design Essay",LocalDate.of(2026,3,12),50);
        Submission a=new Submission("Asha",coding,LocalDate.of(2026,3,10));
        Submission b=new Submission("Ravi",written,LocalDate.of(2026,3,14));
        System.out.println("Asha's submission for 'Linked List Lab' received (on time). Status: Submitted.");
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late). Status: Submitted.");
        a.grade(45); b.grade(40); a.grade(45);
    }
}