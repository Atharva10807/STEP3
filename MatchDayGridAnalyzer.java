public class MatchDayGridAnalyzer {
    static double rowAverage(int[] row) {
        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (i > 0) {
                result.append(" | ");
            }

            result.append("Match ")
                  .append(i)
                  .append(": ")
                  .append(average >= threshold ? "Power Surge" : "Normal");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
