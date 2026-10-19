import java.util.*;

abstract class Appliance {
    double hours;
    Appliance(double hours) { this.hours = hours; }
    abstract double powerWatts();
    boolean supportsSaver() { return false; }
    double units(boolean saver) {
        double units = powerWatts() * hours / 1000.0;
        return saver ? units * 0.75 : units;
    }
}

interface SaverMode {
    boolean supportsSaverMode();
}

class Fridge extends Appliance {
    Fridge(double hours) { super(hours); }
    double powerWatts() { return 150.0; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) { super(hours); }
    double powerWatts() { return 1500.0; }
    public boolean supportsSaverMode() { return true; }
    boolean supportsSaver() { return true; }
}

class Television extends Appliance {
    Television(double hours) { super(hours); }
    double powerWatts() { return 100.0; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) { super(hours); }
    double powerWatts() { return 500.0; }
    public boolean supportsSaverMode() { return true; }
    boolean supportsSaver() { return true; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("(?i)SAVER");
            if (saver) sc.next();
            Appliance appliance;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(hours); break;
                case "AC": appliance = new AirConditioner(hours); break;
                case "TV": appliance = new Television(hours); break;
                case "WASHER": appliance = new WashingMachine(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance type");
            }
            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.units(saver);
            double cost = units * 8.0;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
