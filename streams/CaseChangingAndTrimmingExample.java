import java.util.Scanner;

public class CaseChangingAndTrimmingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        String modifiedString = inputString.toLowerCase().trim();
        System.out.println("Lowercase and Trimmed: " + modifiedString);

        scanner.close();
    }
}
