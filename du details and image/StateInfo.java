import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface StateInfo extends Remote {
    StateDetails getStateDetails(String stateName) throws RemoteException;
    byte[] getStateImage(String stateName) throws RemoteException;
}
