import java.util.*;

public class HostelElectricityBill {
    interface Room {
        double calculateBill();
        String getType();
    }

    static class SingleRoom implements Room {
        int units;

        SingleRoom(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 8.0;
        }

        public String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom implements Room {
        int units;
        int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double calculateBill() {
            return units * 6.0 / occupants;
        }

        public String getType() {
            return "SHARED";
        }
    }

    static class ACRoom implements Room {
        int units;

        ACRoom(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 10.0 + 200;
        }

        public String getType() {
            return "AC";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    rooms.add(new SharedRoom(units, sc.nextInt()));
                    break;
                default:
                    rooms.add(new ACRoom(units));
            }
        }

        double total = 0;

        for (Room room : rooms) {
            double bill = room.calculateBill();
            total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", room.getType(), bill);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
