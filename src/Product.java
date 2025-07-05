public class Product implements Shippable {
    String name;
    double price;
    int quantity;
    long expirationDate; // 0 means no expiration
    boolean shippable;
    double weight; // in kg

    public Product(String name, double price, int quantity, long expirationDate, boolean shippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.shippable = shippable;
        this.weight = weight;
    }

    boolean isExpired() {
        return expirationDate > 0 && System.currentTimeMillis() > expirationDate;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}

