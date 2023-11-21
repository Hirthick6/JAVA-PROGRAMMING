import java.util.Scanner;

public class StringFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainString = "";

        while (true) {
            System.out.println("\nString Functions Menu:");
            System.out.println("1. Add a string");
            System.out.println("2. Verify strings are equal");
            System.out.println("3. Extract first 3 characters");
            System.out.println("4. Insert 'Hai' at position 2 in 'hello'");
            System.out.println("5. Reverse a string");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to add: ");
                    String newString = scanner.nextLine();
                    mainString += newString;
                    System.out.println("Result: " + mainString);
                    break;
                case 2:
                    System.out.print("Enter the second string to compare: ");
                    String compareString = scanner.nextLine();
                    if (mainString.equals(compareString)) {
                        System.out.println("Strings are equal.");
                    } else {
                        System.out.println("Strings are not equal.");
                    }
                    break;
                case 3:
                    String firstThreeCharacters = mainString.substring(0, Math.min(mainString.length(), 3));
                    System.out.println("First three characters: " + firstThreeCharacters);
                    break;
                case 4:
                    StringBuilder hello = new StringBuilder("hello");
                    hello.insert(1, "Hai");
                    System.out.println("After inserting 'Hai' at position 2: " + hello);
                    break;
                case 5:
                    StringBuilder reversedString = new StringBuilder(mainString).reverse();
                    System.out.println("Reversed string: " + reversedString);
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
