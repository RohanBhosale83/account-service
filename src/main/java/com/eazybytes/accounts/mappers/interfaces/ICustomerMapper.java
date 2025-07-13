package com.eazybytes.accounts.mappers.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.model.Customer;

/**
 * Interface for mapping customer-related data.
 * This interface defines methods for converting between Customer, CustomerInfo, and AccountsInfo objects.
 */
public interface ICustomerMapper
{
    /**
     * Maps a Customer object to a CustomerInfo object.
     * This method extracts customer details such as ID, name, email, and mobile number
     * from the Customer object and populates a new CustomerInfo object.
     *
     * @param customer The Customer object containing customer details.
     * @return A CustomerInfo object populated with customer information.
     */
    CustomerInfo mapToCustomerInfo(Customer customer);

    /**
     * Maps a CustomerInfo object and an optional AccountsInfo object to a Customer object.
     * This method populates the Customer object with details from CustomerInfo and, if provided,
     * maps account details from AccountsInfo to the Customer's associated Accounts object.
     *
     * @param customerInfo The CustomerInfo object containing customer details.
     * @param accountsInfo The AccountsInfo object containing account details (optional).
     * @return A Customer object populated with customer and account information.
     */
    Customer mapToCustomer(CustomerInfo customerInfo, AccountsInfo accountsInfo);
}