package com.eazybytes.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity class representing customer information in the database.
 * This class is annotated with JPA and Lombok annotations to facilitate
 * ORM mapping and reduce boilerplate code.
 */
@Entity
@Data
public class CustomerInfo extends MetadataInfo
{
    /**
     * The unique identifier for the customer.
     * This field is marked as the primary key for the entity.
     */
    @Id
    private Long customerId;

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email address of the customer.
     */
    private String email;

    /**
     * The mobile number of the customer.
     */
    private String mobileNumber;
}