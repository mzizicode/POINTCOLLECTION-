

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


// Mark the class as a Spring Boot application entry point
@SpringBootApplication
@EnableFeignClients
public class ProductApplication  {
    public static void main(String[] args) {
        // Run the Spring Boot application and bootstrap the ProductApplication class
        SpringApplication.run(ProductApplication.class, args);
    }
}