**Steps to run:**

Clone this project and run the following command  `sbt clean test` followed by `sbt run` 

Please run the server first(MyServer class). Open another process to run the client this time( ClientOperation Class) using `sbt run` again.

**_Note: Please make sure that no process is using the port `6060`. Kill the process or please provide another valid port in the rmi.conf file_**