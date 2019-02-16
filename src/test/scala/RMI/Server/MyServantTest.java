package RMI.Server;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.rmi.RemoteException;


public class MyServantTest {

    static MyServant myServant;

    @BeforeClass
    public static void init() throws RemoteException {
        myServant = new MyServant();
    }

    @Test
    public void VerifyHelloTo() throws RemoteException {
        String testString = "TEST_STRING";

        String response = myServant.helloTo(testString);

        Assert.assertEquals("Invalid Response", "Server says hello to TEST_STRING", response);
    }

    @Test
    public void VerifyReferentialIntegrity() throws RemoteException {
        Object builder = new StringBuilder("MohammedSiddiq");

        //creating an alias for the object
        Object builderAlias = builder;

        Boolean response = myServant.verifyReferences(builder, builderAlias);

        Assert.assertTrue(response);
    }

}