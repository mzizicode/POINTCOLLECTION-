package com.wizardcoding.amqp.repository;

import com.wizardcoding.amqp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

// Spring Data JPA repository interface for the "Product" entity
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query using a native SQL query to retrieve product information based on customer ID
    @Query(nativeQuery = true, // Indicates that a native SQL query is being used
            value = "SELECT id, name, price, stock, product_serial FROM product WHERE id = :customerId" // SQL query
    )
    Optional<Product> findProductByCustomerId(@Param("customerId") Long customerId);
// The method signature indicates a custom query to find a product by customer ID
// The @Param annotation is used to map the method parameter to the named parameter in the SQL query
}