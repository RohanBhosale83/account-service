package com.eazybytes.accounts.repository.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing account-related database operations.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods for the AccountsInfo entity.
 * It is annotated with @Repository to indicate that it is a Spring-managed component.
 */
@Repository
public interface IAccountRepository extends JpaRepository<AccountsInfo, Long>
{
    /**
     * Retrieves account information based on the customer ID.
     *
     * @param customerId The unique identifier of the customer.
     * @return The AccountsInfo entity associated with the given customer ID.
     */
    AccountsInfo findByCustomerId(Long customerId);

    /**
     * Deletes account information based on the customer ID.
     *
     * @param customerId The unique identifier of the customer.
     */
    void deleteByCustomerId(Long customerId);
}