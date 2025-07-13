package com.eazybytes.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity class representing account information in the database.
 * This class is annotated with JPA and Lombok annotations to facilitate
 * ORM mapping and reduce boilerplate code.
 */
@Entity
@Data
public class AccountsInfo extends MetadataInfo
{
    /**
     * The unique identifier of the customer associated with the account.
     */
    private Long customerId;

    /**
     * The unique account number for the account.
     * This field is marked as the primary key for the entity.
     */
    @Id
    private Long accountNumber;

    /**
     * The type of account (e.g., Savings, Current).
     */
    private String accountType;

    /**
     * The address of the branch where the account is maintained.
     */
    private String branchAddress;
}