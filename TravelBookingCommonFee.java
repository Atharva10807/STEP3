import java.util.*;

abstract class Booking {
    static final double BOOKING_FEE = 50.0;
    double distance;
    Booking(double distance) { this.distance = distance; }
    abstract double baseFare();
    double totalFare() { return baseFare() + BOOKING_FEE; }
}

class BusBooking extends Booking {
    BusBooking(double distance) { super(distance); }
    double baseFare() { return distance * 2.0; }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) { super(distance); }
    double baseFare() { return distance * 1.5; }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) { super(distance); }
    double baseFare() { return 2500.0 + distance * 4.0; }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            Booking booking;
            switch (mode) {
                case "BUS": booking = new BusBooking(distance); break;
                case "TRAIN": booking = new TrainBooking(distance); break;
                case "FLIGHT": booking = new FlightBooking(distance); break;
                default: throw new IllegalArgumentException("Unknown travel mode");
            }
            System.out.printf(Locale.US, "%s: %.2f%n", mode, booking.totalFare());
        }
    }
}
