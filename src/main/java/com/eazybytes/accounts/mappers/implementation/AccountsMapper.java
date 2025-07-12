package com.eazybytes.accounts.mappers.implementation;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.mappers.interfaces.IAccountsMapper;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class AccountsMapper implements IAccountsMapper
{
    @Override
    public AccountsInfo mapToAccountsInfo(Customer customer)
    {
        AccountsInfo accountsInfo = null;
        if (customer.getAccounts() != null)
        {
            Accounts accounts = customer.getAccounts();
            accountsInfo = new AccountsInfo();
            accountsInfo.setCustomerId(customer.getCustomerId());
            accountsInfo.setAccountNumber(accounts.getAccountNumber());
            accountsInfo.setAccountType(accounts.getAccountType());
            accountsInfo.setBranchAddress(accounts.getBranchAddress());
        }
        return accountsInfo;
    }
}
