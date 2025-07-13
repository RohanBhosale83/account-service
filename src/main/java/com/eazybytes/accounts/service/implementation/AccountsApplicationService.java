package com.eazybytes.accounts.service.implementation;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.exception.EntityAlreadyExistsException;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.repository.interfaces.IAccountRepository;
import com.eazybytes.accounts.repository.interfaces.ICustomerRepository;
import com.eazybytes.accounts.service.interfaces.IAccountsApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class responsible for handling business operations related to
 * Customer and Account management.
 */
@Service
@AllArgsConstructor
public class AccountsApplicationService implements IAccountsApplicationService
{

    private final ICustomerRepository customerRepository;
    private final IAccountRepository accountRepository;

    /**
     * Creates a new customer and associated account.
     *
     * @param customerInfo Information about the customer to be created.
     * @param accountsInfo Information about the account to be created.
     * @throws EntityAlreadyExistsException if the customer already exists.
     */
    @Override
    public void createAccount(CustomerInfo customerInfo, AccountsInfo accountsInfo)
    {
        if (customerInfo != null)
        {
            if (customerRepository.findById(customerInfo.getCustomerId()).isPresent())
            {
                throw new EntityAlreadyExistsException("Customer with this mobile number already exists.");
            }
            customerRepository.save(customerInfo);
        }
        if (accountsInfo != null)
        {
            accountRepository.save(accountsInfo);
        }
    }

    /**
     * Retrieves account details for a given customer ID.
     *
     * @param customerId   Unique ID of the customer.
     * @param mobileNumber Mobile number of the customer (currently unused in logic).
     * @return Account information associated with the customer.
     */
    @Override
    public AccountsInfo getAccount(Long customerId, String mobileNumber)
    {
        return accountRepository.findByCustomerId(customerId);
    }

    /**
     * Retrieves customer details using the mobile number.
     *
     * @param mobileNumber Mobile number of the customer.
     * @return Customer information if found.
     * @throws ResourceNotFoundException if no customer is found with the given mobile number.
     */
    @Override
    public CustomerInfo getCustomer(String mobileNumber)
    {
        CustomerInfo customerInfo = customerRepository.findByMobileNumber(mobileNumber);
        if (customerInfo != null)
            return customerInfo;
        else
            throw new ResourceNotFoundException("Account not found mobile number: " + mobileNumber);
    }

    /**
     * Updates existing customer and account information.
     *
     * @param customerInfo Updated customer information.
     * @param accountsInfo Updated account information.
     */
    @Override
    public void updateAccount(CustomerInfo customerInfo, AccountsInfo accountsInfo)
    {
        if (customerInfo != null)
        {
            customerRepository.save(customerInfo);
        }
        if (accountsInfo != null)
        {
            accountRepository.save(accountsInfo);
        }
    }

    /**
     * Deletes both the account and customer information using the mobile number.
     *
     * @param mobileNumber Mobile number of the customer to delete.
     */
    @Transactional
    @Override
    public void deleteAccount(String mobileNumber)
    {
        CustomerInfo customerInfo = customerRepository.findByMobileNumber(mobileNumber);
        if (customerInfo != null)
        {
            accountRepository.deleteByCustomerId(customerInfo.getCustomerId());
            customerRepository.delete(customerInfo);
        }
    }
}
