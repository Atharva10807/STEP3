import java.util.*;

public class PublicTransportFareCalculator {
    interface Transport {
        double calculateFare();
        String getType();
    }

    static class Bus implements Transport {
        double distance;

        Bus(double distance) {
            this.distance = distance;
        }

        public double calculateFare() {
            return Math.min(2 + 0.10 * distance, 10);
        }

        public String getType() {
            return "BUS";
        }
    }

    static class Train implements Transport {
        double distance;

        Train(double distance) {
            this.distance = distance;
        }

        public double calculateFare() {
            return 3 + 0.15 * distance;
        }

        public String getType() {
            return "TRAIN";
        }
    }

    static class Metro implements Transport {
        double distance;
        double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        public double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }

        public String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double distance = Double.parseDouble(input[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                default:
                    journeys.add(new Metro(distance, Double.parseDouble(input[2])));
            }
        }

        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", journey.getType(), fare);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
