import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StateInfoServer extends UnicastRemoteObject implements StateInfo {
    private Map<String, StateDetails> stateDetails;
    private Map<String, byte[]> stateImages;
    private final String imageDirectory = "images/"; // Replace with the actual image directory.

    public StateInfoServer() throws RemoteException {
        super();
        stateDetails = new HashMap<>();
        stateImages = new HashMap<>();
        // Initialize state details and images
        stateDetails.put("California", new StateDetails("Sacramento", "39.14 million", "423,970 square kilometers"));
        stateImages.put("California", loadStateImage("california"));
        // Add more states as needed.
    }

    @Override
    public StateDetails getStateDetails(String stateName) throws RemoteException {
        return stateDetails.get(stateName);
    }

    @Override
    public byte[] getStateImage(String stateName) throws RemoteException {
        return stateImages.get(stateName);
    }

    private byte[] loadStateImage(String stateName) {
        try {
            File imageFile = new File(imageDirectory + stateName + ".jpg");
            FileInputStream fileInputStream = new FileInputStream(imageFile);
            long imageSize = imageFile.length();
            byte[] imageData = new byte[(int) imageSize];
            fileInputStream.read(imageData);
            fileInputStream.close();
            return imageData;
        } catch (IOException e) {
            System.err.println("Exception while loading image: " + e.toString());
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static void main(String[] args) {
        try {
            StateInfoServer server = new StateInfoServer();
            Naming.rebind("StateInfoServer", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
