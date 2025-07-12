package com.eazybytes.accounts.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Response
{
    private String statusCode;
    private String statusMessage;
}
