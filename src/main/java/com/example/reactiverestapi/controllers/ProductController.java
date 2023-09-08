package com.example.reactiverestapi.controllers;

import com.example.reactiverestapi.model.Product;
import com.example.reactiverestapi.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository repo;

    public ProductController(final ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<Flux<Product>> list(){
        return ResponseEntity.ofNullable(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Product>> findById(@PathVariable long id){
        return ResponseEntity.ofNullable(repo.findById(id));
    }
}
