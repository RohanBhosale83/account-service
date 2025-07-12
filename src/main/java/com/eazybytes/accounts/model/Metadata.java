package com.eazybytes.accounts.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Metadata
{
    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
