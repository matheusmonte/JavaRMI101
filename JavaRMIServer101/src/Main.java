import server.MessengerService;
import server.MessengerServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

    public static void main(String[] args) throws RemoteException {
        System.out.println("Starting Server App");
        int port = 1099;
        try {
            MessengerService server = new MessengerServiceImpl();
            MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject((MessengerService) server, 0);

            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("MessengerService", stub);

            System.out.println("Server application running in " + port);
        }
        catch (Exception e){
            System.out.println("Error while starting server" + e.getMessage());
        }
     }
}
