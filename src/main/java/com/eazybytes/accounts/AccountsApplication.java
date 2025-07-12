package com.eazybytes.accounts;

import com.eazybytes.accounts.audit.AuditAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(
        { "com.eazybytes.accounts.entity", "com.eazybytes.accounts.model", "com.eazybytes.accounts.mappers.interfaces",
                "com.eazybytes.accounts.service.interfaces", "com.eazybytes.accounts.controller.interfaces",
                "com.eazybytes.accounts.controller.implementation", "com.eazybytes.accounts.repository.interfaces" })
@EnableJpaRepositories("com.eazybytes.accounts.repository.interfaces")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(AccountsApplication.class, args);
    }
}
