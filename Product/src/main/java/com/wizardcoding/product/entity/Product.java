package com.wizardcoding.amqp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

// Mark the class as a Data class using Lombok annotations
@Data
// Mark the class as an entity for JPA (Java Persistence API)
@Entity
// Use Lombok annotations to automatically generate a Builder pattern
@Builder
// Generate an all-args constructor
@AllArgsConstructor
// Generate a no-args constructor
@NoArgsConstructor
// Define the Product class, representing an entity in the application domain.
public class Product {
    // Annotate the id field as the primary key for the Product entity.
    @Id
    // Define a sequence generator for the primary key.
    @SequenceGenerator(
            name = "product_id_sequence",            // Specify a name for the sequence generator.
            sequenceName = "product_id_sequence"     // Specify the name of the database sequence to be used.
    )
    // Generate a value for the primary key using the specified strategy and generator.
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,    // Use a sequence-based generation strategy.
            generator = "product_id_sequence"        // Reference the sequence generator defined above.
    )
    // Declare the id field, representing the primary key of the Product entity.
    private Long id;

    // Declare the name field, representing the name of the product.
    private String name;

    // Declare the price field, representing the price of the product.
    private double price;

    // Declare the stock field, representing the available stock of the product.
    private int stock;

    private String productSerial;

    // Declare the points field, representing the points associated with the product.

}

