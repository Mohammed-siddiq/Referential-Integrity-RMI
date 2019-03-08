## Referential Integrity Verification in RMI 


Remote Method Invocation in Java allows a client to invoke a method on the server(remote) as though the method exists in the footprint of the client.
Though the client and server are running on different instances of JVM. The parameter passing in RMI ensures that if aliases of the objects/references are passed as parameters to the remote method.
RMI ensures passing these by reference giving the remote JVM a referential access to the objects - maintaining the referential integrity.


**Steps to run:**

Clone this project and run the following command  `sbt clean test` followed by `sbt run` 

Please run the server first(MyServer class). Open another process to run the client this time( ClientOperation Class) using `sbt run` again.

**_Note: Please make sure that no process is using the port `6060`. Kill the process or please provide another valid port in the rmi.conf file_**