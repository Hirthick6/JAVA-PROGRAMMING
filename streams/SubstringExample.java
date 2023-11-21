import java.util.Scanner;

public class SubstringExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter the start index of the substring: ");
        String startIndexStr = scanner.nextLine();
        int startIndex = Integer.parseInt(startIndexStr);

        System.out.print("Enter the end index of the substring: ");
        int endIndex = scanner.nextInt();

        String substring = inputString.substring(startIndex, endIndex);
        System.out.println("Substring: " + substring);

        scanner.close();
    }
}
