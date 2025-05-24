package com.menglang.spring_webflux.controllers;

import com.menglang.spring_webflux.dtos.product.Product;
import com.menglang.spring_webflux.services.product.ProductService;
import com.menglang.spring_webflux.utils.Transformer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProducts(){
        String path="products/get";

        return productService.getProduct().transform(Transformer.fluxLogger(path));
    }

    @GetMapping(value = "/error",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProductsWithError(){
        String path="products/get";
        return productService.getProductWithError().transform(Transformer.fluxLogger(path));
    }

    @GetMapping("/sample")
    public List<Product> getTraditionalProducts(){
        List<Product> products=productService.getProducts();
        log.info("products fetch: {}",products.size());
        return products;
    }

}
