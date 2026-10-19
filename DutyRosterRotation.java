import java.util.Scanner;
import java.util.Arrays;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        long k = sc.nextLong();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}
