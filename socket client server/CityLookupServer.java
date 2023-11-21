import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class CityLookupServer {
    private static Map<String, String> cityDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Populate the city database
        cityDatabase.put("12345", "New York");
        cityDatabase.put("67890", "Los Angeles");
        cityDatabase.put("98765", "Chicago");

        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Use an available port

            System.out.println("Server is running. Waiting for client connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Start a new thread to handle the client's request
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Set up input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read the PIN code from the client
                String pinCode = in.readLine();

                // Look up the city for the PIN code
                String city = cityDatabase.get(pinCode);

                // Send the city back to the client
                if (city != null) {
                    out.println("City for PIN " + pinCode + ": " + city);
                } else {
                    out.println("City not found for PIN " + pinCode);
                }

                // Close the socket and streams
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}