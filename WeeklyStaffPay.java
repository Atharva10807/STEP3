import java.util.*;

abstract class Staff {
    String name;
    Staff(String name) { this.name = name; }
    abstract double pay();
}

class FullTimeStaff extends Staff {
    double salary;
    FullTimeStaff(String name, double salary) { super(name); this.salary = salary; }
    double pay() { return salary; }
}

class HourlyStaff extends Staff {
    double hours, rate;
    HourlyStaff(String name, double hours, double rate) {
        super(name); this.hours = hours; this.rate = rate;
    }
    double pay() {
        return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    double stipend;
    InternStaff(String name, double stipend) { super(name); this.stipend = stipend; }
    double pay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Staff staff;
            switch (type) {
                case "FULLTIME": staff = new FullTimeStaff(name, sc.nextDouble()); break;
                case "HOURLY": staff = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()); break;
                case "INTERN": staff = new InternStaff(name, sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown staff type");
            }
            double pay = staff.pay();
            System.out.printf(Locale.US, "%s: %.2f%n", name, pay);
            total += pay;
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
