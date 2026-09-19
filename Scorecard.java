class Scorec {
    private final boolean[] results;
    private int answerCount;

    Scorec(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    void recordAnswer(boolean result) {
        if (answerCount < results.length) {
            results[answerCount] = result;
            answerCount++;
        }
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class Scorecard {
    public static void main(String[] args) {
        Scorec sc = new Scorec(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}