package com.wizardcoding.customer.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Mark the class as a Data class using Lombok annotations
@Data
// Use Lombok annotations to automatically generate a Builder pattern
@Builder
@AllArgsConstructor
@NoArgsConstructor
// Mark the class as an entity for JPA (Java Persistence API)
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;



}
