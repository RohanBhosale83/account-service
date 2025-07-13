package com.eazybytes.accounts.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Represents a generic response model for API calls.
 * This class is annotated with @Component to indicate that it is a Spring-managed bean,
 * and @Data to automatically generate boilerplate code such as getters, setters, and toString methods.
 */
@Component
@Data
public class Response
{
    /**
     * The status code of the response, indicating the result of the API call.
     */
    private String statusCode;

    /**
     * The status message providing additional details about the response.
     */
    private String statusMessage;
}