package com.eazybytes.accounts.mappers.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import com.eazybytes.accounts.model.Customer;

/**
 * Interface for mapping customer-related data to account-related data.
 * This interface defines methods for converting between Customer and AccountsInfo objects.
 */
public interface IAccountsMapper
{
    /**
     * Maps a Customer object to an AccountsInfo object.
     * This method extracts account-related details from the Customer object and
     * populates an AccountsInfo object with the relevant information.
     *
     * @param customer The Customer object containing account details.
     * @return An AccountsInfo object populated with account information.
     */
    AccountsInfo mapToAccountsInfo(Customer customer);
}