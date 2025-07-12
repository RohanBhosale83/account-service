package com.eazybytes.accounts.repository.interfaces;

import com.eazybytes.accounts.entity.AccountsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountsInfo, Long>
{
    AccountsInfo findByCustomerId(Long customerId);

    void deleteByCustomerId(Long customerId);
}
