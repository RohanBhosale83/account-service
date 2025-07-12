package com.eazybytes.accounts.service.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import org.springframework.stereotype.Service;

@Service
public interface IAccountsApplicationService
{
    void createAccount(CustomerInfo customerInfo, AccountsInfo accountsInfo);

    AccountsInfo getAccount(Long customerId, String mobileNumber);

    CustomerInfo getCustomer(String mobileNumber);

    void updateAccount(CustomerInfo customerInfo, AccountsInfo accountsInfo);

    void deleteAccount(String mobileNumber);
}
