import java.util.*;
public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (int i = 0; i < cart.items.size(); i++) {
            CartItem item = cart.items.get(i);
            if (item.product.isExpired()) {
                System.out.println(item.product.name + " is expired");
                return;
            }
            if (item.quantity > item.product.quantity) {
                System.out.println(item.product.name + " is out of stock");
                return;
            }
            subtotal += item.product.price * item.quantity;
            if (item.product.shippable) {
                for (int j = 0; j < item.quantity; j++) {
                    shippableItems.add(item.product);
                }
            }
        }

        if (!shippableItems.isEmpty()) {
            shipping = 30;
        }

        double total = subtotal + shipping;

        if (customer.balance < total) {
            System.out.println("Insufficient balance");
            return;
        }

        for (int i = 0; i < cart.items.size(); i++) {
            CartItem item = cart.items.get(i);
            item.product.quantity -= item.quantity;
        }
        customer.balance -= total;

        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        System.out.println("** Checkout receipt **");
        for (int i = 0; i < cart.items.size(); i++) {
            CartItem item = cart.items.get(i);
            System.out.println(item.quantity + "x " + item.product.name + " " + (item.product.price * item.quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shipping);
        System.out.println("Amount " + total);
        System.out.println("Remaining Balance " + customer.balance);
        System.out.println("END.\n");
    }
}
