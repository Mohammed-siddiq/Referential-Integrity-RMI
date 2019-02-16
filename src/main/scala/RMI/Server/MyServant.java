package RMI.Server;

import RMI.MyInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * An implementation of the remote methods
 */

public class MyServant extends UnicastRemoteObject implements MyInterface {

    Logger logger = LoggerFactory.getLogger("MyServant");


    protected MyServant() throws RemoteException {

        super();

    }

    @Override
    public String helloTo(String name) throws RemoteException {

        logger.info(name + " is trying to contact!");
        logger.info("Received Greetings " + name);
        return "Server says hello to " + name;

    }

    @Override
    public Boolean verifyReferences(Object a, Object alias) {

        if (a.equals(alias)) {
            logger.info("case 1: Referential Integrity verified.....");
            return true;
        }
        logger.info("case 2: The two objects passed are different...");
        return false;
    }


}