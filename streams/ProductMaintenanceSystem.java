import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String brand;
    private double price;

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(double discountPercentage) {
        price = price - (price * discountPercentage / 100);
    }
}

public class ProductMaintenanceSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", "Brand1", 100.0));
        products.add(new Product("Product2", "Brand2", 150.0));
        products.add(new Product("Product3", "Brand1", 200.0));
        products.add(new Product("Product4", "Brand3", 120.0));

        System.out.print("Enter the target brand: ");
        String targetBrand = scanner.nextLine();

        System.out.print("Enter the discount percentage: ");
        double discountPercentage = scanner.nextDouble();

        List<Product> discountedProducts = products.stream()
                .filter(product -> product.getBrand().equals(targetBrand))
                .peek(product -> product.applyDiscount(discountPercentage))
                .collect(Collectors.toList());

        System.out.println("Products of brand " + targetBrand + " after applying " + discountPercentage + "% discount:");
        discountedProducts.forEach(product -> System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice()));

        // Finding maximum and minimum price products after applying discounts
        Product maxPriceProduct = products.stream()
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .orElse(null);

        Product minPriceProduct = products.stream()
                .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .orElse(null);

        System.out.println("Product with maximum price: Name: " + maxPriceProduct.getName() + ", Price: " + maxPriceProduct.getPrice());
        System.out.println("Product with minimum price: Name: " + minPriceProduct.getName() + ", Price: " + minPriceProduct.getPrice());
    }
}
