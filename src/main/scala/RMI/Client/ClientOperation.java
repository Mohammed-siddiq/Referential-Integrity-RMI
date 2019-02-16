package RMI.Client;

import RMI.MyInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Simple client that looks up for the stub and invokes the remote method to verify referential integrity.
 */
public class ClientOperation {


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Logger logger = LoggerFactory.getLogger("ClientOperation");

        logger.debug("Loading Configs");
        Config conf = ConfigFactory.load("rmi");

        logger.info("Starting Client");

        logger.debug(conf.getString("URL"));

        //Look for the stub associated with the name
        MyInterface myServant = (MyInterface) Naming.lookup(conf.getString("URL"));

        System.out.println(myServant.helloTo("Siddiq!!"));


        //create an object
        Object builder = new StringBuilder("MohammedSiddiq");

        //creating an alias for the object
        Object builderAlias = builder;

        logger.info("case 1: Invoking Remote method with references pointing to same object.");
        //Invoking a remote method passing object and its alias to verify the reference and the
        myServant.verifyReferences(builder, builderAlias);


        //Creating a different object
        Object newBuilder = new StringBuilder("Mohammed Siddiq");

        logger.info("case 2: Invoking Remote method with two different objects");
        myServant.verifyReferences(builder, newBuilder);
        logger.info("Exiting Client...");


    }
}
