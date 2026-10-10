import java.util.*;

abstract class Question {
    String text;
    int points;
    Question(String text, int points) { this.text = text; this.points = points; }
    abstract boolean evaluate(String answer);
}
class MCQ extends Question {
    String correct;
    MCQ(String t, int p, String c) { super(t, p); correct = c; }
    boolean evaluate(String a) { return correct.equalsIgnoreCase(a); }
}
class TrueFalse extends Question {
    String correct;
    TrueFalse(String t, int p, String c) { super(t, p); correct = c; }
    boolean evaluate(String a) { return correct.equalsIgnoreCase(a); }
}
class Attempt {
    private final String student, exam;
    private final Map<Question,String> answers = new LinkedHashMap<>();
    private boolean submitted;
    Attempt(String student, String exam) { this.student = student; this.exam = exam; System.out.println(exam + " started by " + student + "."); }
    void answer(Question q, String a) {
        if (submitted) { System.out.println("Cannot change answers for a submitted examination."); return; }
        answers.put(q, a); System.out.println("Answer recorded for " + q.text + ".");
    }
    void submit() {
        if (submitted) return;
        submitted = true; int score = 0, total = 0;
        System.out.println(exam + " submitted by " + student + ".");
        for (Map.Entry<Question,String> e : answers.entrySet()) {
            Question q = e.getKey(); boolean ok = q.evaluate(e.getValue());
            int marks = ok ? q.points : 0; score += marks; total += q.points;
            System.out.println(q.text + ": " + (ok ? "Correct" : "Incorrect") + " (" + marks + " points)");
        }
        System.out.println("Total score: " + score + "/" + total);
    }
}
class ExaminationDemo {
    public static void main(String[] args) {
        Question q1 = new MCQ("Question 1", 5, "C");
        Question q2 = new TrueFalse("Question 2", 5, "False");
        Attempt a = new Attempt("Student 1", "Exam A");
        a.answer(q1, "C"); a.answer(q2, "True"); a.submit(); a.answer(q1, "A");
    }
}