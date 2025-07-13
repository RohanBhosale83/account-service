package com.eazybytes.accounts.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Represents metadata information for an entity.
 * This class contains common fields for tracking creation and update details.
 * It is annotated with @Data to automatically generate boilerplate code such as getters, setters, and toString methods.
 */
@Data
public class Metadata
{
    /**
     * The timestamp indicating when the entity was created.
     */
    private LocalDateTime createdAt;

    /**
     * The identifier of the user who created the entity.
     */
    private String createdBy;

    /**
     * The timestamp indicating when the entity was last updated.
     */
    private LocalDateTime updatedAt;

    /**
     * The identifier of the user who last updated the entity.
     */
    private String updatedBy;
}