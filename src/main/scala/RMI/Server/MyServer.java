package RMI.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 */
public class MyServer {
    public static void main(String[] args) throws RemoteException {
        Logger logger = LoggerFactory.getLogger("MyServer");

        logger.info("Starting Server...");
        logger.info("Creating Registry on port 6060");
        Registry registry = LocateRegistry.createRegistry(6060);
        registry.rebind("reference",new MyServant());

    }
}
