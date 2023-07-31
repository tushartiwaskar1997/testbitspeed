package com.bitspeed.bitespeed.repositories;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerInsertRepo {

    @PersistenceContext
    private EntityManager entityManager;
    
}
