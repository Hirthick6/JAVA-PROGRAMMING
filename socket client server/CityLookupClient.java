import java.io.*;
import java.net.Socket;

public class CityLookupClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost"; // Change this to the server's address
            int serverPort = 12345; // Use the same port as the server

            Socket socket = new Socket(serverAddress, serverPort);

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a PIN code to the server
            String pinCode = "67890"; // Change this to the PIN code you want to look up
            out.println(pinCode);

            // Receive the city from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close the socket and streams
            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}