package com.eazybytes.accounts.mappers.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.model.Customer;


public interface ICustomerMapper
{
    CustomerInfo mapToCustomerInfo(Customer customer);

    Customer mapToCustomer(CustomerInfo customerInfo, AccountsInfo accountsInfo);
}
