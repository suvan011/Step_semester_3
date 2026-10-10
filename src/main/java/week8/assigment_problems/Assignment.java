import java.time.*;
abstract class Assignment {
    String title; int maxMarks; LocalDate dueDate;
    Assignment(String title,int maxMarks,LocalDate dueDate){this.title=title;this.maxMarks=maxMarks;this.dueDate=dueDate;}
    abstract double penaltyPerDay();
    double finalMarks(int awarded, LocalDate submitted){
        long days=Math.max(0,java.time.temporal.ChronoUnit.DAYS.between(dueDate,submitted));
        return Math.max(0,Math.min(maxMarks,awarded)*(1-penaltyPerDay()*days));
    }
}
class CodingAssignment extends Assignment {
    CodingAssignment(String t,int m,LocalDate d){super(t,m,d);}
    double penaltyPerDay(){return .10;}
}
class WrittenAssignment extends Assignment {
    WrittenAssignment(String t,int m,LocalDate d){super(t,m,d);}
    double penaltyPerDay(){return .20;}
}
class StudentSubmission {
    private final String student; private final Assignment assignment; private final LocalDate date;
    private String status="Submitted"; private double marks;
    StudentSubmission(String s,Assignment a,LocalDate d){student=s;assignment=a;date=d;System.out.println(s+"'s submission for '"+a.title+"' received. Status: Submitted.");}
    void grade(int awarded){
        if(!status.equals("Submitted")){System.out.println("Cannot grade a submission that is already graded.");return;}
        marks=assignment.finalMarks(awarded,date);status="Graded";
        long late=Math.max(0,java.time.temporal.ChronoUnit.DAYS.between(assignment.dueDate,date));
        System.out.println(student+" graded: "+String.format("%.0f",marks)+"/"+assignment.maxMarks+(late>0?" after "+(int)(late*assignment.penaltyPerDay()*100)+"% late penalty":"")+". Status: "+status);
    }
    void resubmit(){if(status.equals("Graded"))System.out.println("Cannot resubmit: '"+assignment.title+"' has already been graded.");else System.out.println("Resubmission accepted.");}
}
class AssignmentDemo {
    public static void main(String[] args){
        Assignment coding=new CodingAssignment("Linked List Lab",50,LocalDate.of(2026,3,10));
        Assignment written=new WrittenAssignment("Design Essay",50,LocalDate.of(2026,3,12));
        StudentSubmission a=new StudentSubmission("Asha",coding,LocalDate.of(2026,3,10));
        StudentSubmission r=new StudentSubmission("Ravi",written,LocalDate.of(2026,3,14));
        a.grade(45);r.grade(40);a.resubmit();
    }
}