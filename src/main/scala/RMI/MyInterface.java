package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * An interface defining two simple methods
 */

public interface MyInterface extends Remote {


    /**
     * A simple method written to verify RMI
     * @param name A sample string passed from the client
     * @return Returns the same string
     * @throws RemoteException
     */
    String helloTo(String name) throws RemoteException;

    /**
     *
     * @param a An object that will be compared with other object passed
     * @param alias An alias of object a (or another object)
     * @return True if referential integrity is maintained or else False
     * @throws RemoteException
     */

    Boolean verifyReferences(Object a, Object alias) throws RemoteException;

}