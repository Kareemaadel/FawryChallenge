public class Main {
    public static void main(String[] args) {
        long oneDay = 24L * 60 * 60 * 1000;
        long ProductionDate = System.currentTimeMillis();

        Product cheese = new Product("Cheese", 100, 5, ProductionDate + oneDay, true, 0.4);
        Product biscuits = new Product("Biscuits", 150, 3, ProductionDate + 365*oneDay, true, 0.7);
        Product tv = new Product("TV", 2000, 10, 0, true, 8);
        Product scratchCard = new Product("Scratch Card", 50, 20, 0, false, 0);
        Product expiredMilk = new Product("Milk", 80, 5, ProductionDate - oneDay, true, 1);

        System.out.println("Test Case 1: normal checkout");
        Customer customer1 = new Customer("Ali", 1000);
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(biscuits, 1);
        cart1.add(scratchCard, 1);
        CheckoutService.checkout(customer1, cart1);

        System.out.println("Test Case 2: expired product");
        Customer customer2 = new Customer("Kimo", 1000);
        Cart cart2 = new Cart();
        cart2.add(expiredMilk, 1);
        CheckoutService.checkout(customer2, cart2);

        System.out.println("Test Case 3: insufficient balance");
        Customer customer3 = new Customer("Sameh", 100);
        Cart cart3 = new Cart();
        cart3.add(cheese, 2);
        cart3.add(biscuits, 1);
        CheckoutService.checkout(customer3, cart3);

        System.out.println("Test Case 4: empty cart");
        Customer customer4 = new Customer("Dina", 500);
        Cart cart4 = new Cart();
        CheckoutService.checkout(customer4, cart4);

        System.out.println("Test Case 5: product out of stock");
        Customer customer5 = new Customer("Nada", 10000);
        Cart cart5 = new Cart();
        cart5.add(tv, 100);
        CheckoutService.checkout(customer5, cart5);
    }
}