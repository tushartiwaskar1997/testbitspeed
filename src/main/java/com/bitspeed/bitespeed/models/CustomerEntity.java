package com.bitspeed.bitespeed.models;

import java.time.LocalDateTime;

import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


   // entitymanager.packagesToScan:com.bitspeed.bitespeed.models

@Entity
@Table(name="customer")
@Data
public class CustomerEntity {
    
    @Id
    private int  id;

    private  String  phoneNumber ;

    private  String  email;

    private  String  linked_id ;

    private  String  link_precedence  ;

    private  LocalDateTime created_at ;

    
    private  LocalDateTime updated_at ;

    
    private  LocalDateTime deleted_at ;              

}
