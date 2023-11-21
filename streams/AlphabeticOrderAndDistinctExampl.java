import java.util.Scanner;
import java.util.stream.Collectors;

public class AlphabeticOrderAndDistinctExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        String resultString = inputString.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Letters in Alphabetic Order without Duplicates: " + resultString);

        scanner.close();
    }
}
