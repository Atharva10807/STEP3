import java.util.*;

abstract class Student {
    String name;
    Student(String name) { this.name = name; }
    abstract double tuitionAndOtherFees();
    boolean usesBus() { return false; }
    double totalFee() { return tuitionAndOtherFees() + (usesBus() ? 12000.0 : 0.0); }
}

class DayScholar extends Student {
    DayScholar(String name) { super(name); }
    double tuitionAndOtherFees() { return 40000.0; }
    boolean usesBus() { return true; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    double tuitionAndOtherFees() { return 100000.0; }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) { super(name); }
    double tuitionAndOtherFees() { return 20000.0; }
    boolean usesBus() { return true; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student student;
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new ScholarshipStudent(name); break;
                default: throw new IllegalArgumentException("Unknown student type");
            }
            double fee = student.totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", name, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
