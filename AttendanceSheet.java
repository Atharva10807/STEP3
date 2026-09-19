class Attendance {
    private final String[] students;
    private int count;

    Attendance(int maxStudents) {
        students = new String[maxStudents];
        count = 0;
    }

    void markPresent(String name) {
        if (!isPresent(name) && count < students.length) {
            students[count] = name;
            count++;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class AttendanceSheet{
    public static void main(String[] args) {
        Attendance sheet = new Attendance(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}