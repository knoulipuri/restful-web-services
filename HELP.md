# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.BUILD-SNAPSHOT/maven-plugin/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

# To open h2 console in browser:


http://localhost:8080/h2-console

Driver Class:org.h2.Driver

JDBC URL: jdbc:h2:~/test (DB stored in user directory)

JDBC URL: jdbc:h2:tcp://localhost/~/test (Remote (client/server))

JDBC URL: jdbc:h2:mem:test

H2 Database URLs
 ### Embedded:

The URL jdbc:h2:~/test means the database is stored in the user home directory in files starting with 'test'. Absolute locations like jdbc:h2:/data/db/test are supported. In embedded mode, the database runs in the same process as the application. Only one process may access a database at any time. Databases are automatically created if they don't exist if you have a permission. URLs of the form jdbc:h2:./data/test are relative to the current working directory (the directory where the application was started). It is recommended to use locations relative to ~ or absolute locations.

### Remote (client/server)

The URL jdbc:h2:tcp://localhost/~/test means connect over TCP/IP to the H2 TCP server running on this computer, and open a database called test in the user home directory. The server must be started first. Any number of clients can connect to the same database. The same location rules as for embedded databases apply.

### In-Memory

The URL jdbc:h2:mem:test means open an in-memory database named 'test'. Data is not persisted, and lost when the last connection to the database is closed. Multiple threads can access the same database, but data is only visible within the same process. 

### Notes:
* Richardson Maturity Model
* Github Repository       
   **https://github.com/in28minutes**
   **https://github.com/in28minutes/spring-microservices**

