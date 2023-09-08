package com.example.reactiverestapi.repositories;

import com.example.reactiverestapi.model.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Reactive Repository
 */
@Repository
public interface ProductRepository extends R2dbcRepository<Product, Long> {
}
