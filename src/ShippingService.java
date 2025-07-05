import java.util.*;
public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        List<String> printed = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            Shippable current = items.get(i);
            boolean alreadyPrinted = false;
            for (int k = 0; k < printed.size(); k++) {
                if (printed.get(k).equals(current.getName())) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if (alreadyPrinted == true) {
                continue;
            }

            int count = 0;
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).getName().equals(current.getName())) {
                    count++;
                    totalWeight += items.get(j).getWeight();
                }
            }

            System.out.println(count + "x " + current.getName() + " " + (current.getWeight() * 1000) + "g");
            printed.add(current.getName());
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
