import java.util.*;

public class PaymentSystemFeeCalculator {
    interface PaymentMethod {
        double calculateAmount(double amount);
        String getType();
    }

    static class CardPayment implements PaymentMethod {
        public double calculateAmount(double amount) {
            return amount * 1.02;
        }

        public String getType() {
            return "CARD";
        }
    }

    static class WalletPayment implements PaymentMethod {
        public double calculateAmount(double amount) {
            return amount * 1.01;
        }

        public String getType() {
            return "WALLET";
        }
    }

    static class BankTransferPayment implements PaymentMethod {
        public double calculateAmount(double amount) {
            return amount;
        }

        public String getType() {
            return "BANKTRANSFER";
        }
    }

    static class Transaction {
        PaymentMethod paymentMethod;
        double amount;

        Transaction(PaymentMethod paymentMethod, double amount) {
            this.paymentMethod = paymentMethod;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transaction> transactions = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double amount = Double.parseDouble(input[1]);
            PaymentMethod method;

            switch (type) {
                case "CARD":
                    method = new CardPayment();
                    break;
                case "WALLET":
                    method = new WalletPayment();
                    break;
                default:
                    method = new BankTransferPayment();
            }

            transactions.add(new Transaction(method, amount));
        }

        for (Transaction transaction : transactions) {
            double adjusted = transaction.paymentMethod.calculateAmount(transaction.amount);
            total += adjusted;
            System.out.printf(Locale.US, "%s: %.2f%n", transaction.paymentMethod.getType(), adjusted);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
