package com.example.reactiverestapi.controllers;

import com.example.reactiverestapi.model.Produto;
import com.example.reactiverestapi.repositories.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * https://spring.io/projects/spring-data-r2dbc
 * https://hantsy.github.io/spring-reactive-sample/data/data-r2dbc.html
 * https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-methods/responseentity.html
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoRepository repo;

    public ProdutoController(final ProdutoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<Flux<Produto>> list(){
        return ResponseEntity.ofNullable(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Produto>> findById(@PathVariable long id){
        return ResponseEntity.ofNullable(repo.findById(id));
    }
}
