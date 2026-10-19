import java.util.*;

public class CampusParkingChargeCalculator {
    interface Vehicle {
        double calculateCharge();
        String getType();
    }

    static class Bike implements Vehicle {
        int hours;

        Bike(int hours) {
            this.hours = hours;
        }

        public double calculateCharge() {
            return hours * 10.0;
        }

        public String getType() {
            return "BIKE";
        }
    }

    static class Car implements Vehicle {
        int hours;

        Car(int hours) {
            this.hours = hours;
        }

        public double calculateCharge() {
            return 30 + (hours - 1) * 20.0;
        }

        public String getType() {
            return "CAR";
        }
    }

    static class Truck implements Vehicle {
        int hours;

        Truck(int hours) {
            this.hours = hours;
        }

        public double calculateCharge() {
            return Math.max(hours * 50.0, 100.0);
        }

        public String getType() {
            return "TRUCK";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                default:
                    vehicles.add(new Truck(hours));
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            total += charge;
            System.out.printf(Locale.US, "%s: %.2f%n", vehicle.getType(), charge);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
