package RMI.Server;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * Server implementation of the RMI
 */
public class MyServer {
    public static void main(String[] args) throws RemoteException {
        Logger logger = LoggerFactory.getLogger("MyServer");

        logger.debug("Loading Configs");
        Config conf = ConfigFactory.load("rmi");

        logger.info("Starting Server...");
        logger.info("Creating Registry ");

        //Creating registry
        Registry registry = LocateRegistry.createRegistry(conf.getInt("PORT"));

        registry.rebind(conf.getString("REMOTE_METHOD_NAME"), new MyServant());


    }
}
