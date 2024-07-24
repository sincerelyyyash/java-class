import java.util.List;
import java.util.ArrayList;

class Product {
    private String name;
    private int quantity;
    private double price;
    private double discount;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        return price * (1 - discount / 100);
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                p.updateQuantity(p.getQuantity() + product.getQuantity());
                return;
            }
        }
        products.add(product);
    }

    public void removeProduct(String productName, int quantity) {
        for (int i = 0; i < products.size(); i++) {
            Product prod = products.get(i);
            if (prod.getName().equals(productName)) {
                if (prod.getQuantity() <= quantity) {
                    products.remove(i);
                } else {
                    prod.updateQuantity(prod.getQuantity() - quantity);
                }
                return;
            }
        }
    }

    public void applyDiscount(String productName, double discount) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.updateDiscount(discount);
                return;
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getDiscountedPrice() * product.getQuantity();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 51000, 10, 0);
        Product phone = new Product("Mobile", 20000, 5, 0);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(laptop);
        cart.addProduct(phone);

        cart.applyDiscount("Laptop", 10);

        double totalPrice = cart.calculateTotal();
        System.out.printf("Total price: $%.2f%n", totalPrice);

        cart.removeProduct("Mobile", 2);

        totalPrice = cart.calculateTotal();
        System.out.printf("Total price after removing phones: $%.2f%n", totalPrice);
    }
}

