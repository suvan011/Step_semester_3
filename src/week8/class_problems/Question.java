import java.util.*;

abstract class Question {
    String text;
    int points;
    Question(String text, int points) { this.text = text; this.points = points; }
    abstract boolean isCorrect(String answer);
}
class MultipleChoiceQuestion extends Question {
    String correct;
    MultipleChoiceQuestion(String text, int points, String correct) { super(text, points); this.correct = correct; }
    boolean isCorrect(String answer) { return correct.equalsIgnoreCase(answer); }
}
class TrueFalseQuestion extends Question {
    boolean correct;
    TrueFalseQuestion(String text, int points, boolean correct) { super(text, points); this.correct = correct; }
    boolean isCorrect(String answer) { return Boolean.toString(correct).equalsIgnoreCase(answer); }
}
class Examination {
    String title;
    List<Question> questions = new ArrayList<>();
    Examination(String title) { this.title = title; }
    void add(Question q) { questions.add(q); }
}
class Attempt {
    private final Examination exam;
    private final Map<Question,String> answers = new LinkedHashMap<>();
    private boolean submitted = false;
    Attempt(Examination exam) { this.exam = exam; System.out.println(exam.title + " started."); }
    void answer(Question q, String answer) {
        if (submitted) { System.out.println("Cannot change answers for a submitted examination."); return; }
        answers.put(q, answer); System.out.println("Answer recorded for " + q.text);
    }
    void submit() {
        if (submitted) return;
        submitted = true; int score = 0, total = 0;
        for (Question q : exam.questions) {
            total += q.points;
            boolean ok = q.isCorrect(answers.getOrDefault(q, ""));
            if (ok) score += q.points;
            System.out.println(q.text + ": " + (ok ? "Correct" : "Incorrect") + " (" + (ok ? q.points : 0) + " points)");
        }
        System.out.println("Total score: " + score + "/" + total);
    }
}
class QuestionDemo {
    public static void main(String[] args) {
        Examination e = new Examination("Exam A");
        Question q1 = new MultipleChoiceQuestion("Question 1", 5, "C");
        Question q2 = new TrueFalseQuestion("Question 2", 5, false);
        e.add(q1); e.add(q2);
        Attempt a = new Attempt(e); a.answer(q1, "C"); a.answer(q2, "True"); a.submit(); a.answer(q1, "A");
    }
}