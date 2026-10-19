import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StreamingPlanRenewalReminder {
    interface Plan {
        int getValidityDays();
    }

    static class BasicPlan implements Plan {
        public int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan implements Plan {
        public int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan implements Plan {
        public int getValidityDays() {
            return 365;
        }
    }

    static class Subscriber {
        String name;
        LocalDate startDate;
        Plan plan;

        Subscriber(String name, LocalDate startDate, Plan plan) {
            this.name = name;
            this.startDate = startDate;
            this.plan = plan;
        }

        LocalDate getRenewalDate() {
            return startDate.plusDays(plan.getValidityDays());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Subscriber> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next(), formatter);
            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan();
                    break;
                case "STANDARD":
                    plan = new StandardPlan();
                    break;
                default:
                    plan = new PremiumPlan();
            }

            subscribers.add(new Subscriber(name, startDate, plan));
        }

        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber.name + ": " + subscriber.getRenewalDate().format(formatter));
        }

        sc.close();
    }
}
