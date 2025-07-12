package com.eazybytes.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CustomerInfo extends MetadataInfo
{
    @Id
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;

}
