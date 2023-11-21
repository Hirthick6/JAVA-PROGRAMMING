import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server {
    private static final HashMap<String, String> synonyms = new HashMap<>();

    static {
        // Initialize the word-synonym mapping
        synonyms.put("happy", "joyful");
        synonyms.put("sad", "unhappy");
        synonyms.put("big", "large");
        synonyms.put("small", "tiny");
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Start a new thread to handle the client request
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                String word;
                while ((word = in.readLine()) != null) {
                    String synonym = synonyms.getOrDefault(word.toLowerCase(), "Not found");
                    out.println(synonym);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
