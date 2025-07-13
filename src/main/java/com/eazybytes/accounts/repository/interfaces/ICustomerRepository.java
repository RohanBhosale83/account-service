package com.eazybytes.accounts.repository.interfaces;

import com.eazybytes.accounts.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing customer-related database operations.
 * This interface extends JpaRepository to provide CRUD operations and custom query methods for the CustomerInfo entity.
 * It is annotated with @Repository to indicate that it is a Spring-managed component.
 */
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerInfo, Long>
{
    /**
     * Retrieves customer information based on the mobile number.
     *
     * @param mobileNumber The mobile number of the customer.
     * @return The CustomerInfo entity associated with the given mobile number.
     */
    CustomerInfo findByMobileNumber(String mobileNumber);
}