import java.util.*;

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;
    double km;
    Cab(double km) { this.km = km; }
    abstract double ratePerKm();
    double fare() { return Math.max(km * ratePerKm(), MINIMUM_FARE); }
}

interface NightService {
    double applyNightFare(double fare);
}

class MiniCab extends Cab {
    MiniCab(double km) { super(km); }
    double ratePerKm() { return 10.0; }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) { super(km); }
    double ratePerKm() { return 14.0; }
    public double applyNightFare(double fare) { return fare * 1.2; }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) { super(km); }
    double ratePerKm() { return 18.0; }
    public double applyNightFare(double fare) { return fare * 1.2; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            Cab cab;
            switch (type) {
                case "MINI": cab = new MiniCab(km); break;
                case "SEDAN": cab = new SedanCab(km); break;
                case "SUV": cab = new SUVCab(km); break;
                default: throw new IllegalArgumentException("Unknown cab type");
            }
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.fare();
            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
