package com.eazybytes.accounts.mappers.implementation;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.entity.CustomerInfo;
import com.eazybytes.accounts.mappers.interfaces.ICustomerMapper;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements ICustomerMapper
{
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
