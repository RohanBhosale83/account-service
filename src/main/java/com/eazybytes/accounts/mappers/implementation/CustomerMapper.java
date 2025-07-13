package com.eazybytes.accounts.mappers.implementation;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.mappers.interfaces.ICustomerMapper;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import org.springframework.stereotype.Component;

/**
 * Implementation of the ICustomerMapper interface.
 * This class provides functionality to map between Customer and CustomerInfo objects,
 * as well as between CustomerInfo and Customer objects with associated AccountsInfo.
 * It is annotated with @Component to indicate that it is a Spring-managed bean.
 */
@Component
public class CustomerMapper implements ICustomerMapper
{
    /**
     * Maps a Customer object to a CustomerInfo object.
     * This method extracts details such as customer ID, name, email, and mobile number
     * from the Customer object and populates a new CustomerInfo object.
     *
     * @param customer The Customer object containing customer details.
     * @return A CustomerInfo object populated with customer information.
     */
    @Override
    public CustomerInfo mapToCustomerInfo(Customer customer)
    {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerId(customer.getCustomerId());
        customerInfo.setName(customer.getName());
        customerInfo.setEmail(customer.getEmail());
        customerInfo.setMobileNumber(customer.getMobileNumber());
        return customerInfo;
    }

    /**
     * Maps a CustomerInfo object and an optional AccountsInfo object to a Customer object.
     * This method populates the Customer object with details from CustomerInfo and, if provided,
     * maps account details from AccountsInfo to the Customer's associated Accounts object.
     *
     * @param customerInfo The CustomerInfo object containing customer details.
     * @param accountsInfo The AccountsInfo object containing account details (optional).
     * @return A Customer object populated with customer and account information.
     */
    @Override
    public Customer mapToCustomer(CustomerInfo customerInfo, AccountsInfo accountsInfo)
    {
        Customer customer = new Customer();
        customer.setCustomerId(customerInfo.getCustomerId());
        customer.setName(customerInfo.getName());
        customer.setEmail(customerInfo.getEmail());
        customer.setMobileNumber(customerInfo.getMobileNumber());
        customer.setCreatedBy(customerInfo.getCreatedBy());
        customer.setCreatedAt(customerInfo.getCreatedAt());
        customer.setUpdatedBy(customerInfo.getUpdatedBy());
        customer.setUpdatedAt(customerInfo.getUpdatedAt());
        if (accountsInfo != null)
        {
            Accounts accounts = new Accounts();
            accounts.setCustomerId(accountsInfo.getCustomerId());
            accounts.setAccountNumber(accountsInfo.getAccountNumber());
            accounts.setAccountType(accountsInfo.getAccountType());
            accounts.setBranchAddress(accountsInfo.getBranchAddress());
            accounts.setCreatedBy(accountsInfo.getCreatedBy());
            accounts.setCreatedAt(accountsInfo.getCreatedAt());
            accounts.setUpdatedBy(accountsInfo.getUpdatedBy());
            accounts.setUpdatedAt(accountsInfo.getUpdatedAt());
            customer.setAccounts(accounts);
        }
        return customer;
    }
}