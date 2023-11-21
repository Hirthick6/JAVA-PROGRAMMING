import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.print("Enter a word: ");
            String word = userInput.readLine();

            // Send the word to the server
            out.println(word);

            // Receive and print the synonym from the server
            String synonym = in.readLine();
            System.out.println("Synonym: " + synonym);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
