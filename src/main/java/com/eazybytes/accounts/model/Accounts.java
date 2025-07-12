package com.eazybytes.accounts.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Accounts extends Metadata
{
    private Long customerId;

    @NotNull(message = "AccountNumber cannot be null or empty")
    @Id
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be empty")
    @NotNull(message = "Account type cannot be null")
    private String accountType;

    @NotEmpty(message = "Branch name cannot be empty")
    @NotNull(message = "Branch name cannot be null")
    private String branchAddress;

}
