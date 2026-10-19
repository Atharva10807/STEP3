import java.util.*;

public class CanteenBillingCounter {
    interface Customer {
        double calculateAmount(double amount);
        String getType();
    }

    static class Student implements Customer {
        public double calculateAmount(double amount) {
            return amount * 0.90;
        }

        public String getType() {
            return "STUDENT";
        }
    }

    static class Staff implements Customer {
        public double calculateAmount(double amount) {
            return amount * 0.95;
        }

        public String getType() {
            return "STAFF";
        }
    }

    static class Guest implements Customer {
        public double calculateAmount(double amount) {
            return amount + 10;
        }

        public String getType() {
            return "GUEST";
        }
    }

    static class Bill {
        Customer customer;
        double amount;

        Bill(Customer customer, double amount) {
            this.customer = customer;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Bill> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student();
                    break;
                case "STAFF":
                    customer = new Staff();
                    break;
                default:
                    customer = new Guest();
            }

            bills.add(new Bill(customer, amount));
        }

        double total = 0;

        for (Bill bill : bills) {
            double finalAmount = bill.customer.calculateAmount(bill.amount);
            total += finalAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", bill.customer.getType(), finalAmount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
