package com.eazybytes.accounts.repository.interfaces;

import com.eazybytes.accounts.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerInfo, Long>
{
    CustomerInfo findByMobileNumber(String mobileNumber);
}
