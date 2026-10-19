import java.util.*;

abstract class Plot {
    String owner;
    Plot(String owner) { this.owner = owner; }
    abstract double area();
    abstract String shape();
}

class CirclePlot extends Plot {
    double radius;
    CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
    String shape() { return "CIRCLE"; }
}

class RectanglePlot extends Plot {
    double length, width;
    RectanglePlot(String owner, double length, double width) {
        super(owner); this.length = length; this.width = width;
    }
    double area() { return length * width; }
    String shape() { return "RECTANGLE"; }
}

class TrianglePlot extends Plot {
    double base, height;
    TrianglePlot(String owner, double base, double height) {
        super(owner); this.base = base; this.height = height;
    }
    double area() { return 0.5 * base * height; }
    String shape() { return "TRIANGLE"; }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String owner = sc.next();
            Plot plot;
            switch (type) {
                case "CIRCLE": plot = new CirclePlot(owner, sc.nextDouble()); break;
                case "RECTANGLE": plot = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()); break;
                case "TRIANGLE": plot = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown plot shape");
            }
            double area = plot.area();
            System.out.printf(Locale.US, "%s (%s): %.2f%n", owner, plot.shape(), area);
            total += area;
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
