package com.eazybytes.accounts.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global exception handler for the application.
 * This class provides centralized exception handling for controllers using Spring's @ControllerAdvice annotation.
 * It extends ResponseEntityExceptionHandler to handle validation-related exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    /**
     * Handles ResourceNotFoundException and returns a custom error response.
     *
     * @param exception  The ResourceNotFoundException thrown by the application.
     * @param webRequest The current web request.
     * @return A ResponseEntity containing the custom error response with HTTP status NOT_FOUND.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<com.eazybytes.accounts.model.ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
    {
        com.eazybytes.accounts.model.ErrorResponse errorResponse = new com.eazybytes.accounts.model.ErrorResponse(
                webRequest.getDescription(false), HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles EntityAlreadyExistsException and returns a custom error response.
     *
     * @param exception  The EntityAlreadyExistsException thrown by the application.
     * @param webRequest The current web request.
     * @return A ResponseEntity containing the custom error response with HTTP status BAD_REQUEST.
     */
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<com.eazybytes.accounts.model.ErrorResponse> handleEntityAlreadyExists(EntityAlreadyExistsException exception, WebRequest webRequest)
    {
        com.eazybytes.accounts.model.ErrorResponse errorResponse = new com.eazybytes.accounts.model.ErrorResponse(
                webRequest.getDescription(false), HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles generic exceptions and returns a custom error response.
     *
     * @param exception  The generic exception thrown by the application.
     * @param webRequest The current web request.
     * @return A ResponseEntity containing the custom error response with HTTP status INTERNAL_SERVER_ERROR.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.eazybytes.accounts.model.ErrorResponse> handleGlobalException(Exception exception, WebRequest webRequest)
    {
        com.eazybytes.accounts.model.ErrorResponse errorResponse = new com.eazybytes.accounts.model.ErrorResponse(
                webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles validation errors for method arguments and returns a map of field-specific error messages.
     *
     * @param ex      The MethodArgumentNotValidException thrown during validation.
     * @param headers The HTTP headers.
     * @param status  The HTTP status code.
     * @param request The current web request.
     * @return A ResponseEntity containing a map of validation errors with HTTP status BAD_REQUEST.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
    {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }
}