import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class LibraryItemDueDateCalculator {
    interface LibraryItem {
        int getLoanDays();
    }

    static class Book implements LibraryItem {
        public int getLoanDays() {
            return 14;
        }
    }

    static class DVD implements LibraryItem {
        public int getLoanDays() {
            return 7;
        }
    }

    static class Magazine implements LibraryItem {
        public int getLoanDays() {
            return 3;
        }
    }

    static class BorrowedItem {
        LibraryItem item;
        String title;

        BorrowedItem(LibraryItem item, String title) {
            this.item = item;
            this.title = title;
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
        List<BorrowedItem> items = new ArrayList<>();
        LocalDate currentDate = LocalDate.parse("2023-10-26");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            List<String> parts = parseLine(sc.nextLine());
            String type = parts.get(0);
            String title = parts.get(1);
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book();
                    break;
                case "DVD":
                    item = new DVD();
                    break;
                default:
                    item = new Magazine();
            }

            items.add(new BorrowedItem(item, title));
        }

        for (BorrowedItem borrowed : items) {
            LocalDate dueDate = currentDate.plusDays(borrowed.item.getLoanDays());
            System.out.println(borrowed.title + ": " + dueDate.format(formatter));
        }

        sc.close();
    }
}
