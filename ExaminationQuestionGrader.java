import java.util.*;
import java.util.regex.*;

public class ExaminationQuestionGrader {
    interface Question {
        double grade();
        String getType();
    }

    static class MCQ implements Question {
        String correctAnswer;
        String studentAnswer;
        double points;

        MCQ(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }

        public String getType() {
            return "MCQ";
        }
    }

    static class TrueFalse implements Question {
        String correctAnswer;
        String studentAnswer;
        double points;

        TrueFalse(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }

        public String getType() {
            return "TF";
        }
    }

    static class Essay implements Question {
        String correctAnswer;
        String studentAnswer;
        double points;

        Essay(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public double grade() {
            String answer = studentAnswer.toLowerCase(Locale.ROOT);
            int matched = 0;

            for (String keyword : correctAnswer.split(",")) {
                String key = keyword.trim().toLowerCase(Locale.ROOT);
                if (!key.isEmpty() && answer.contains(key)) {
                    matched++;
                }
            }

            if (matched >= 2) {
                return points * 0.75;
            }
            if (matched == 1) {
                return points * 0.50;
            }
            return 0;
        }

        public String getType() {
            return "ESSAY";
        }
    }

    static List<String> parseLine(String line) {
        List<String> parts = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

        while (matcher.find()) {
            parts.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }

        return parts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            List<String> input = parseLine(sc.nextLine());
            String type = input.get(0);
            String correct = input.get(2);
            String student = input.get(3);
            double points = Double.parseDouble(input.get(4));

            switch (type) {
                case "MCQ":
                    questions.add(new MCQ(correct, student, points));
                    break;
                case "TF":
                    questions.add(new TrueFalse(correct, student, points));
                    break;
                default:
                    questions.add(new Essay(correct, student, points));
            }
        }

        for (Question question : questions) {
            double score = question.grade();
            total += score;
            System.out.printf(Locale.US, "%s: %.2f%n", question.getType(), score);
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        sc.close();
    }
}
