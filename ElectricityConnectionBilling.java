import java.util.*;

abstract class Connection {
    int units;
    Connection(int units) { this.units = units; }
    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(int units) { super(units); }
    double bill() {
        return Math.min(units, 100) * 5.0 + Math.max(0, units - 100) * 7.0;
    }
}

class ShopConnection extends Connection {
    ShopConnection(int units) { super(units); }
    double bill() { return units * 8.0 + 100.0; }
}

class FactoryConnection extends Connection {
    FactoryConnection(int units) { super(units); }
    double bill() { return Math.max(units * 6.0, 1000.0); }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            Connection connection;
            switch (type) {
                case "HOME": connection = new HomeConnection(units); break;
                case "SHOP": connection = new ShopConnection(units); break;
                case "FACTORY": connection = new FactoryConnection(units); break;
                default: throw new IllegalArgumentException("Unknown connection type");
            }
            double bill = connection.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
