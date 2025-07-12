package com.eazybytes.accounts.mappers.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;

public interface IAccountsMapper
{
    AccountsInfo mapToAccountsInfo(Customer customer);
}
