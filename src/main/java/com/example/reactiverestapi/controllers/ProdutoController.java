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
