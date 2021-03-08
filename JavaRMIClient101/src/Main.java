import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        communicateWithServer();

    }

    private static void communicateWithServer() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            MessengerService server = (MessengerService) registry.lookup("MessengerService");
            String responseMessage = server.sendMessage("Client Message");
            System.out.println(responseMessage);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
