package com.eazybytes.accounts.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Represents an account entity in the application.
 * This class is annotated with @Component to indicate that it is a Spring-managed bean,
 * and @Data to automatically generate boilerplate code such as getters, setters, and toString methods.
 * It extends the Metadata class to inherit common metadata fields.
 */
@Component
@Data
public class Accounts extends Metadata
{
    /**
     * The ID of the customer associated with the account.
     */
    private Long customerId;

    /**
     * The unique account number for the account.
     * This field is annotated with @Id to indicate it is the primary key,
     * and @NotNull to enforce that it cannot be null or empty.
     */
    @NotNull(message = "AccountNumber cannot be null or empty")
    @Id
    private Long accountNumber;

    /**
     * The type of the account (e.g., savings, checking).
     * This field is annotated with @NotEmpty and @NotNull to ensure it is not null or empty.
     */
    @NotEmpty(message = "Account type cannot be empty")
    @NotNull(message = "Account type cannot be null")
    private String accountType;

    /**
     * The branch address associated with the account.
     * This field is annotated with @NotEmpty and @NotNull to ensure it is not null or empty.
     */
    @NotEmpty(message = "Branch name cannot be empty")
    @NotNull(message = "Branch name cannot be null")
    private String branchAddress;
}