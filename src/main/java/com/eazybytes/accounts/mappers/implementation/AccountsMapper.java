package com.eazybytes.accounts.mappers.implementation;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.mappers.interfaces.IAccountsMapper;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import org.springframework.stereotype.Component;

/**
 * Implementation of the IAccountsMapper interface.
 * This class provides functionality to map Customer objects to AccountsInfo objects.
 * It is annotated with @Component to indicate that it is a Spring-managed bean.
 */
@Component
public class AccountsMapper implements IAccountsMapper
{
    /**
     * Maps a Customer object to an AccountsInfo object.
     * If the Customer has associated Accounts, the method populates the AccountsInfo object
     * with relevant details such as customer ID, account number, account type, and branch address.
     *
     * @param customer The Customer object containing account details.
     * @return An AccountsInfo object populated with account information, or null if no accounts are present.
     */
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