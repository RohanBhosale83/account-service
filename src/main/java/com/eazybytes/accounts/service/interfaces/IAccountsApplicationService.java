package com.eazybytes.accounts.service.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;

/**
 * Interface defining operations related to account and customer management.
 * <p>
 * Provides methods for creating, retrieving, updating, and deleting
 * customer and account information.
 */
public interface IAccountsApplicationService
{

    /**
     * Creates a new customer and associated account.
     *
     * @param customerInfo The customer information to be created.
     * @param accountsInfo The account information to be associated with the customer.
     */
    void createAccount(CustomerInfo customerInfo, AccountsInfo accountsInfo);

    /**
     * Retrieves the account information for the specified customer ID.
     *
     * @param customerId   The unique ID of the customer.
     * @param mobileNumber The mobile number of the customer (not used in logic but may be used for future enhancements).
     * @return The account information associated with the given customer ID.
     */
    AccountsInfo getAccount(Long customerId, String mobileNumber);

    /**
     * Retrieves the customer information using the mobile number.
     *
     * @param mobileNumber The mobile number of the customer.
     * @return The customer information if found.
     */
    CustomerInfo getCustomer(String mobileNumber);

    /**
     * Updates the given customer and account information.
     *
     * @param customerInfo The updated customer information.
     * @param accountsInfo The updated account information.
     */
    void updateAccount(CustomerInfo customerInfo, AccountsInfo accountsInfo);

    /**
     * Deletes the customer and their associated account using the mobile number.
     *
     * @param mobileNumber The mobile number of the customer to delete.
     */
    void deleteAccount(String mobileNumber);
}
