package com.eazybytes.accounts.service.implementation;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.exception.EntityAlreadyExistsException;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.repository.interfaces.IAccountRepository;
import com.eazybytes.accounts.repository.interfaces.ICustomerRepository;
import com.eazybytes.accounts.service.interfaces.IAccountsApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class AccountsApplicationService implements IAccountsApplicationService
{
    ICustomerRepository customerRepository;

    IAccountRepository accountRepository;

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

    @Override
    public AccountsInfo getAccount(Long customerId, String mobileNumber)
    {
        return accountRepository.findByCustomerId(customerId);
    }

    @Override
    public CustomerInfo getCustomer(String mobileNumber)
    {
        CustomerInfo customerInfo = customerRepository.findByMobileNumber(mobileNumber);
        if (customerInfo != null)
            return customerInfo;
        else
            throw new ResourceNotFoundException("Account not found mobile number: " + mobileNumber);
    }

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
