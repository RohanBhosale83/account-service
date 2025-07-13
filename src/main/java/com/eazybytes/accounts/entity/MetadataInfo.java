package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Base class for metadata information used in entity auditing.
 * This class is annotated with JPA and Spring Data annotations to enable
 * automatic tracking of creation and modification details for entities.
 * It is marked as a MappedSuperclass to allow inheritance by other entity classes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class MetadataInfo
{
    /**
     * The timestamp when the entity was created.
     * This field is automatically populated and cannot be updated.
     */
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    /**
     * The identifier of the user or system that created the entity.
     * This field is automatically populated and cannot be updated.
     */
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    /**
     * The timestamp when the entity was last updated.
     * This field is automatically populated and cannot be inserted manually.
     */
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    /**
     * The identifier of the user or system that last updated the entity.
     * This field is automatically populated and cannot be inserted manually.
     */
    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}