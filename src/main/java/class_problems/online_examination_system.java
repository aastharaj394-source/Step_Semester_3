package class_problems;
import java.util.*;

abstract class Question {
    protected int number;
    protected String text;
    protected int marks;

    Question(int number, String text, int marks) {
        this.number = number;
        this.text = text;
        this.marks = marks;
    }

    public int getNumber() {
        return number;
    }

    public int getMarks() {
        return marks;
    }

    public abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    MultipleChoiceQuestion(int number, String text, int marks,
                           String correctAnswer) {
        super(number, text, marks);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    TrueFalseQuestion(int number, String text, int marks,
                      boolean correctAnswer) {
        super(number, text, marks);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class ShortAnswerQuestion extends Question {
    private String correctAnswer;

    ShortAnswerQuestion(int number, String text, int marks,
                        String correctAnswer) {
        super(number, text, marks);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Examination {
    private String name;
    private ArrayList<Question> questions;

    Examination(String name) {
        this.name = name;
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getTotalMarks() {
        int total = 0;

        for (Question question : questions) {
            total += question.getMarks();
        }

        return total;
    }
}

class Attempt {
    private Student student;
    private Examination examination;
    private HashMap<Integer, String> answers;
    private boolean submitted;

    Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
        answers = new HashMap<>();
        submitted = false;
    }

    public void start() {
        System.out.println(examination.getName() +
                " started by " + student.getName() + ".");
    }

    public void answer(int questionNumber, String answer) {
        if (submitted) {
            System.out.println(
                    "Cannot change answers for a submitted examination.");
            return;
        }

        answers.put(questionNumber, answer);

        System.out.println("Answer recorded for Question " +
                questionNumber + ".");
    }

    public void submit() {
        if (submitted) {
            System.out.println("Examination has already been submitted.");
            return;
        }

        submitted = true;

        System.out.println(examination.getName() +
                " submitted by " +
                student.getName() + ".");

        int totalScore = 0;

        for (Question question : examination.getQuestions()) {
            String answer = answers.get(question.getNumber());

            if (answer != null && question.evaluate(answer)) {
                totalScore += question.getMarks();

                System.out.println("Question " +
                        question.getNumber() +
                        ": Correct (" +
                        question.getMarks() +
                        " points)");
            } else {
                System.out.println("Question " +
                        question.getNumber() +
                        ": Incorrect (0 points)");
            }
        }

        System.out.println("Total score: " +
                totalScore + "/" +
                examination.getTotalMarks());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter examination name: ");
        String examName = sc.nextLine();

        Student student = new Student(studentName);
        Examination exam = new Examination(examName);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter question type (MCQ/TF/Short): ");
            String type = sc.nextLine();

            System.out.print("Enter question: ");
            String text = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            if (type.equalsIgnoreCase("MCQ")) {
                System.out.print("Enter correct option: ");
                String correct = sc.nextLine();

                exam.addQuestion(
                        new MultipleChoiceQuestion(i, text, marks, correct));

            } else if (type.equalsIgnoreCase("TF")) {
                System.out.print("Enter correct answer (true/false): ");
                boolean correct = sc.nextBoolean();
                sc.nextLine();

                exam.addQuestion(
                        new TrueFalseQuestion(i, text, marks, correct));

            } else {
                System.out.print("Enter correct answer: ");
                String correct = sc.nextLine();

                exam.addQuestion(
                        new ShortAnswerQuestion(i, text, marks, correct));
            }
        }

        Attempt attempt = new Attempt(student, exam);

        attempt.start();

        for (Question question : exam.getQuestions()) {
            System.out.print("Enter answer for Question " +
                    question.getNumber() + ": ");

            String answer = sc.nextLine();

            attempt.answer(question.getNumber(), answer);
        }

        attempt.submit();

        System.out.print("Enter question number to change answer: ");
        int questionNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new answer: ");
        String newAnswer = sc.nextLine();

        attempt.answer(questionNumber, newAnswer);

        sc.close();
    }
}