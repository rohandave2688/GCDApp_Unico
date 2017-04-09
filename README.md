Prior steps to build and deployment of the application:
1) Install & start MySQL database server.
2) Create a datasource with jndi name java:/jdbc/mysqlds in wildfly (modify standalone-full.xml to add a data source)
3) Run the db.sql srcipt present in the sql directory in ejb module
4) Create JMS queue "queue/UnicoJMS" either using Wildfly Console or from CLI interface. 

Project structure was generated using mvn archtype:generate

Security Considerations:

1. Both SOAP and REST services are secured using application level security.
2. Security services are provided by non-invasive http interceptors.
3. Clients are required to send user name and encrypted password as http headers(http headers should be "Username" = gcdappuser and "Password" = enrypted(password)).
4. Passwords are encrypted/decrypted using public/private key mechanism.
5. Public key has been uploaded to the github.
6. Application can be further secured by adding Container managed security and enabling SSL on the server.

Technologies used for creating the application:


Wildfly(JBoss) Application Server - Version 10.1.0
MySQL Server : 5.6.34 MySQL Community Server (GPL)
JUnit : Unit Test Framework
Mockito : Mocking framework
Maven : for build integration.
JAX-WS(Soap) : Apache CXF (Default runtime for wildfly)
JAX-RS(Rest) : RestEasy ( Default runtime for wildfly)
Spring : DI Framework used for Unit Testing
Persistence : JPA provided by Hibernate
CDI : DI Framework used for main app
JMS : ActiveMQ (Part of wildfly AS)
SoapUI : For testing Soap Services.

MultiUser Environment:

Applications scales well in multi user environment. 
Each rest call is handled by a new object, while methods to handle Soap calls has been synchronized.

Username/Password (to be set in http headers)
gcdappuser/password
password must be encrypted and Base64 encoded before it is sent to the server.

Testing:
Application was tested using custom build java rest client/Postman and Soap UI.

URLS:
Rest Push Service URL:
http://localhost:8080/GCDApp-web/rest/gcd/push/16/20

SOAP Service WSDL
http://localhost:8080/GCDApp-web/GCDService?wsdl

SOAP Service:
http://localhost:8080/GCDApp-web/GCDService
