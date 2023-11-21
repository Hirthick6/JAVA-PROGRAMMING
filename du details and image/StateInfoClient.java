import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StateInfoClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            int serverPort = 1099; // Default RMI registry port
            Registry registry = LocateRegistry.getRegistry(serverAddress, serverPort);
            StateInfo stateInfo = (StateInfo) registry.lookup("StateInfoServer");

            // Get user input for the state name
            String stateName = "California"; // Replace with user input

            // Request state details and image
            StateDetails details = stateInfo.getStateDetails(stateName);
            byte[] image = stateInfo.getStateImage(stateName);

            // Process and display the state details
            System.out.println("State Details for " + stateName + ":");
            System.out.println("Capital: " + details.getCapital());
            System.out.println("Population: " + details.getPopulation());
            System.out.println("Area: " + details.getArea());

            // Save the image to a file
            saveImageToFile(stateName, image);

            // Display the saved image
            displayImage(stateName);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void saveImageToFile(String stateName, byte[] image) {
        try {
            FileOutputStream fos = new FileOutputStream(stateName + ".jpg");
            fos.write(image);
            fos.close();
            System.out.println("Image saved as " + stateName + ".jpg");
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    private static void displayImage(String stateName) {
        try {
            // You can choose your preferred image viewer or use a default image viewer.
            // Here, we use the default image viewer on Windows.
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + stateName + ".jpg");
        } catch (IOException e) {
            System.err.println("Error opening image: " + e.getMessage());
        }
    }
}
