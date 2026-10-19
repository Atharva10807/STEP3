import java.util.Scanner;

public class ClassAttendanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int present = 0, streak = 0, longest = 0;
        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            if (day == 1) {
                present++;
                streak++;
                if (streak > longest) {
                    longest = streak;
                }
            } else {
                streak = 0;
            }
        }
        System.out.println("Present: " + present + ", Longest streak: " + longest);
    }
}
