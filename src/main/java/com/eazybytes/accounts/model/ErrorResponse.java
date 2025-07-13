package com.eazybytes.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Represents an error response for API calls.
 * This class encapsulates details about the error, including the API path, HTTP status code,
 * error message, and the timestamp when the error occurred.
 */
@Data
@AllArgsConstructor
public class ErrorResponse
{
    /**
     * The path of the API endpoint where the error occurred.
     */
    private String apiPath;

    /**
     * The HTTP status code representing the error.
     */
    private HttpStatus errorCode;

    /**
     * A descriptive message providing details about the error.
     */
    private String errorMessage;

    /**
     * The timestamp indicating when the error occurred.
     */
    private LocalDateTime errorTime;
}