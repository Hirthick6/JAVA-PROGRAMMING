import java.util.Scanner;

class Laptop {
    private String configuration;
    private double price;
    private int batteryTime;

    public Laptop(String configuration, double price, int batteryTime) {
        this.configuration = configuration;
        this.price = price;
        this.batteryTime = batteryTime;
    }

    public double getPrice() {
        return price;
    }

    public int getBatteryTime() {
        return batteryTime;
    }

    public String getConfiguration() {
        return configuration;
    }
}

public class LaptopSorter {

    public static void sortByPrice(Laptop[] laptops) {
        for (int i = 0; i < laptops.length - 1; i++) {
            for (int j = i + 1; j < laptops.length; j++) {
                if (laptops[i].getPrice() > laptops[j].getPrice()) {
                    // Swap laptops[i] and laptops[j]
                    Laptop temp = laptops[i];
                    laptops[i] = laptops[j];
                    laptops[j] = temp;
                }
            }
        }
    }

    public static void sortByBatteryTime(Laptop[] laptops) {
        for (int i = 0; i < laptops.length - 1; i++) {
            for (int j = i + 1; j < laptops.length; j++) {
                if (laptops[i].getBatteryTime() > laptops[j].getBatteryTime()) {
                    // Swap laptops[i] and laptops[j]
                    Laptop temp = laptops[i];
                    laptops[i] = laptops[j];
                    laptops[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of laptops: ");
        int n = scanner.nextInt();
        Laptop[] laptops = new Laptop[n];

        for (int i = 0; i < n; i++) {
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter laptop configuration: ");
            String configuration = scanner.nextLine();
            System.out.print("Enter laptop price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter laptop battery time (in hours): ");
            int batteryTime = scanner.nextInt();

            laptops[i] = new Laptop(configuration, price, batteryTime);
        }

        System.out.println("Sort by:");
        System.out.println("1. Price");
        System.out.println("2. Battery Time");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sortByPrice(laptops);
                break;
            case 2:
                sortByBatteryTime(laptops);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        System.out.println("Laptops sorted:");
        for (Laptop laptop : laptops) {
            System.out.println("Configuration: " + laptop.getConfiguration());
            System.out.println("Price: $" + laptop.getPrice());
            System.out.println("Battery Time: " + laptop.getBatteryTime() + " hours\n");
        }

        scanner.close();
    }
}
