import java.util.*;

abstract class Parcel {
    double weight, declaredValue;
    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    abstract double charge();
    double insurance() { return 0.0; }
    double total() { return charge() + insurance(); }
}

interface Insurable {
    double insuranceAmount(double declaredValue);
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    double charge() { return 40.0 + 10.0 * weight; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    double charge() { return 80.0 + 15.0 * weight; }
    public double insuranceAmount(double declaredValue) { return declaredValue * 0.02; }
    double insurance() { return insuranceAmount(declaredValue); }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    double charge() { return 40.0 + 10.0 * weight + 50.0; }
    public double insuranceAmount(double declaredValue) { return declaredValue * 0.02; }
    double insurance() { return insuranceAmount(declaredValue); }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel;
            switch (type) {
                case "STANDARD": parcel = new StandardParcel(weight, value); break;
                case "EXPRESS": parcel = new ExpressParcel(weight, value); break;
                case "FRAGILE": parcel = new FragileParcel(weight, value); break;
                default: throw new IllegalArgumentException("Unknown parcel type");
            }
            double charge = parcel.charge();
            double insurance = parcel.insurance();
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
