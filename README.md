# spring-boot-sample-data-rest 

Spring Boot demo application Spring Data REST  

## Build & Run

The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. 
To run the application simple use the following maven command:

```shell
mvn spring-boot:run
```

## Using H2’s web console

The console will be auto-configured because the application contains the Spring Boot Developer Tools dependency in pom.xml.
By default the console will be available at:
```shell
/h2-console
 ```
 
The console’s path can be customized using the spring.h2.console.path property.
To see database use the following JDBC URL in the console login page.  

```shell
jdbc:h2:mem:testdb
```

## References

 * https://github.com/spring-projects/spring-data-examples
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html