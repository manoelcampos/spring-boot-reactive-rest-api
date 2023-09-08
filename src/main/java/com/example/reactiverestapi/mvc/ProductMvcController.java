package com.example.reactiverestapi.mvc;

import com.example.reactiverestapi.model.Product;
import com.example.reactiverestapi.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

/**
 * Spring MVC Reactive Controller
 * https://mkyong.com/spring-boot/spring-boot-webflux-thymeleaf-reactive-example/
 */
@Controller
@RequestMapping("/product/list")
@AllArgsConstructor // Includes the all args constructor for dependency injection
public class ProductMvcController {
    private final ProductRepository repo;

    @GetMapping()
    public String list(final Model model){
        //It seems Thymeleaf just works with multiple values (Flux instead of Mono)
        final Flux<Product> products = repo.findAll();
        var reactiveList = new ReactiveDataDriverContextVariable(products, 1);
        model.addAttribute("products", reactiveList);
        return "product/list";
    }
}
