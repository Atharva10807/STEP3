import java.util.*;

public class DeliveryFeeCalculator {
    interface Delivery {
        double calculateFee();
        String getType();
    }

    static class StandardDelivery implements Delivery {
        double weight;
        double distance;

        StandardDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }

        public String getType() {
            return "STANDARD";
        }
    }

    static class ExpressDelivery implements Delivery {
        double weight;
        double distance;

        ExpressDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double calculateFee() {
            return 15 + weight + 0.20 * distance;
        }

        public String getType() {
            return "EXPRESS";
        }
    }

    static class InternationalDelivery implements Delivery {
        double weight;
        double distance;
        double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        public double calculateFee() {
            return 25 + 2 * weight + 0.50 * distance + customsFee;
        }

        public String getType() {
            return "INTERNATIONAL";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double weight = Double.parseDouble(input[1]);
            double distance = Double.parseDouble(input[2]);

            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                default:
                    double customsFee = Double.parseDouble(input[3]);
                    deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            }
        }

        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", delivery.getType(), fee);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
