package com.eazybytes.accounts.exception;

/**
 * Custom exception class to represent entity already exists errors in the application.
 * This exception extends RuntimeException, allowing it to be used for unchecked exceptions.
 */
public class EntityAlreadyExistsException extends RuntimeException
{
    /**
     * Serial version UID for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new EntityAlreadyExistsException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public EntityAlreadyExistsException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new EntityAlreadyExistsException with the specified detail message and cause.
     *
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception (a throwable object).
     */
    public EntityAlreadyExistsException(String message, Throwable cause)
    {
        super(message, cause);
    }
}