package com.eazybytes.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementation of the AuditorAware interface to provide the current auditor information.
 * This class is used for auditing purposes in the application, specifically to track
 * the entity changes made by a specific user or system.
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>
{

    /**
     * Returns the current auditor of the application.
     * <p>
     * This method is invoked by Spring Data JPA during auditing operations to determine
     * the current user or system responsible for the changes. In this implementation,
     * it always returns a fixed value "ACCOUNTS_MS", representing the Accounts Microservice.
     *
     * @return an Optional containing the current auditor's identifier.
     */
    @Override
    public Optional<String> getCurrentAuditor()
    {
        return Optional.of("ACCOUNTS_MS");
    }

}