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

@Component
@Data
public class Customer extends Metadata
{
    @NotNull(message = "Customer ID cannot be null or empty")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10}$", message = "Invalid mobile number format")
    @NotEmpty(message = "Mobile number cannot be empty")
    @NotNull(message = "Mobile number cannot be null")
    private String mobileNumber;

    @Valid
    private Accounts accounts;
}
