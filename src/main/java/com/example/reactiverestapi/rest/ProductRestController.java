package com.example.reactiverestapi.rest;

import com.example.reactiverestapi.model.Product;
import com.example.reactiverestapi.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring REST Reactive Controller
 */
@RestController
@RequestMapping("/product")
@AllArgsConstructor // Includes the all args constructor for dependency injection
public class ProductRestController {
    private final ProductRepository repo;

    @GetMapping
    public ResponseEntity<Flux<Product>> list(){
        return ResponseEntity.ofNullable(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Product>> findById(@PathVariable long id){
        return ResponseEntity.ofNullable(repo.findById(id));
    }
}
