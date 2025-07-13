package com.eazybytes.accounts.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Represents a customer entity in the application.
 * This class is annotated with @Component to indicate that it is a Spring-managed bean,
 * and @Data to automatically generate boilerplate code such as getters, setters, and toString methods.
 * It extends the Metadata class to inherit common metadata fields.
 */
@Component
@Data
public class Customer extends Metadata
{
    /**
     * The unique ID of the customer.
     * This field is annotated with @Id to indicate it is the primary key,
     *
     * @GeneratedValue to specify the generation strategy, and @NotNull to enforce that it cannot be null.
     */
    @NotNull(message = "Customer ID cannot be null or empty")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    /**
     * The name of the customer.
     * This field is annotated with @NotNull and @NotEmpty to ensure it is not null or empty.
     */
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    /**
     * The email address of the customer.
     * This field is annotated with @Email to validate the format of the email address.
     */
    @Email(message = "Invalid email format")
    private String email;

    /**
     * The mobile number of the customer.
     * This field is annotated with @Pattern to enforce a valid format, and @NotNull and @NotEmpty to ensure it is not null or empty.
     */
    @Pattern(regexp = "^\\+?[0-9]{10}$", message = "Invalid mobile number format")
    @NotEmpty(message = "Mobile number cannot be empty")
    @NotNull(message = "Mobile number cannot be null")
    private String mobileNumber;

    /**
     * The associated account details of the customer.
     * This field is annotated with @Valid to ensure that the nested Accounts object is validated.
     */
    @Valid
    private Accounts accounts;
}