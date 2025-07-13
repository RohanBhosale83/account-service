package com.eazybytes.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.eazybytes.accounts.entity")
@EnableJpaRepositories("com.eazybytes.accounts.repository.interfaces")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(AccountsApplication.class, args);
    }
}
