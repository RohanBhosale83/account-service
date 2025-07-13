package com.eazybytes.accounts.controller.interfaces;

import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Interface defining the REST API endpoints for account-related operations.
 * This interface is annotated with Spring Web annotations to define the HTTP methods
 * and request mappings for each operation.
 */
@Validated
@RequestMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IAccountsController
{
    /**
     * Endpoint to create a new account.
     *
     * @param customer The customer details provided in the request body. Must be valid as per the constraints.
     * @return A ResponseEntity containing a Response object indicating the result of the operation.
     */
    @PostMapping("/create")
    ResponseEntity<Response> createAccount(@RequestBody @Valid Customer customer);

    /**
     * Endpoint to retrieve account details based on the mobile number.
     *
     * @param mobileNumber The mobile number provided as a query parameter. Must be a 10-digit number.
     * @return A ResponseEntity containing the Customer object with account details.
     */
    @GetMapping("/get")
    ResponseEntity<Customer> getAccount(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits") String mobileNumber);

    /**
     * Endpoint to update an existing account.
     *
     * @param customer The updated customer details provided in the request body. Must be valid as per the constraints.
     * @return A ResponseEntity containing a Response object indicating the result of the operation.
     */
    @PutMapping("/update")
    ResponseEntity<Response> updateAccount(@RequestBody @Valid Customer customer);

    /**
     * Endpoint to delete an account based on the mobile number.
     *
     * @param mobileNumber The mobile number provided as a query parameter. Must be a 10-digit number.
     * @return A ResponseEntity containing a Response object indicating the result of the operation.
     */
    @DeleteMapping("/delete")
    ResponseEntity<Response> deleteAccount(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits") String mobileNumber);
}