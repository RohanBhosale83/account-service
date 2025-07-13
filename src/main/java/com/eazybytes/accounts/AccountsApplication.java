package com.eazybytes.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry point for the Accounts microservice application.
 * <p>
 * This class configures and boots up the Spring Boot application. It also sets up:
 * <ul>
 *   <li>Entity scanning for JPA entities in the package <code>com.eazybytes.accounts.entity</code>.</li>
 *   <li>Enables JPA repositories located in <code>com.eazybytes.accounts.repository.interfaces</code>.</li>
 *   <li>Enables JPA auditing using the bean named <code>auditAwareImpl</code>.</li>
 * </ul>
 */
@SpringBootApplication
@EntityScan("com.eazybytes.accounts.entity")
@EnableJpaRepositories("com.eazybytes.accounts.repository.interfaces")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication
{

    /**
     * Main method used to launch the Spring Boot application.
     *
     * @param args Command-line arguments passed during application startup.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(AccountsApplication.class, args);
    }
}
