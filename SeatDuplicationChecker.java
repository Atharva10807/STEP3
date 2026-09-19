import java.util.Scanner;
public class SeatDuplicationChecker {
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        int[] duplicates = new int[seatNumbers.length];
        int duplicateCount = 0;
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < duplicateCount; k++) {
                if (duplicates[k] == seatNumbers[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if (alreadyPrinted) {
                continue;
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicates[duplicateCount] = seatNumbers[i];
                    duplicateCount++;
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] seatNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat number " + (i + 1) + ": ");
            seatNumbers[i] = sc.nextInt();
        }
        checkDuplicateSeats(seatNumbers);
        sc.close();
    }
}