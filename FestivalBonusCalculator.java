import java.util.*;

public class FestivalBonusCalculator {
    interface Employee {
        double calculateBonus();
        String getName();
    }

    static class FullTimeEmployee implements Employee {
        String name;
        double salary;

        FullTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculateBonus() {
            return salary * 0.10;
        }

        public String getName() {
            return name;
        }
    }

    static class PartTimeEmployee implements Employee {
        String name;
        double salary;

        PartTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculateBonus() {
            return salary * 0.05;
        }

        public String getName() {
            return name;
        }
    }

    static class Intern implements Employee {
        String name;

        Intern(String name) {
            this.name = name;
        }

        public double calculateBonus() {
            return 2000;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTimeEmployee(name, salary));
                    break;
                case "PARTTIME":
                    employees.add(new PartTimeEmployee(name, salary));
                    break;
                default:
                    employees.add(new Intern(name));
            }
        }

        double total = 0;

        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            total += bonus;
            System.out.printf(Locale.US, "%s: %.2f%n", employee.getName(), bonus);
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
        sc.close();
    }
}
