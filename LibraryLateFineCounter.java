import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;
    LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    abstract double fine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) { super(title, daysLate); }
    double fine() { return daysLate * 2.0; }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) { super(title, daysLate); }
    double fine() { return Math.min(daysLate * 5.0, 50.0); }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) { super(title, daysLate); }
    double fine() { return daysLate * 1.0; }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item;
            switch (type) {
                case "BOOK": item = new BookItem(title, daysLate); break;
                case "DVD": item = new DVDItem(title, daysLate); break;
                case "MAGAZINE": item = new MagazineItem(title, daysLate); break;
                default: throw new IllegalArgumentException("Unknown item type");
            }
            double fine = item.fine();
            System.out.printf(Locale.US, "%s: %.2f%n", title, fine);
            total += fine;
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
