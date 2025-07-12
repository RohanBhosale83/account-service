package com.eazybytes.accounts.controller.interfaces;

import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IAccountsController
{
    @PostMapping("/create")
    ResponseEntity<Response> createAccount(@RequestBody  @Valid Customer customer);

    @GetMapping("/get")
    ResponseEntity<Customer> getAccount(@RequestParam  @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")String mobileNumber);

    @PutMapping("/update")
    ResponseEntity<Response> updateAccount(@RequestBody  @Valid Customer customer);

    @DeleteMapping("/delete")
    ResponseEntity<Response> deleteAccount(@RequestParam  @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")String mobileNumber);

}
