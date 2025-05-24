package com.menglang.spring_webflux.services.product;


import com.menglang.spring_webflux.dtos.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    public Flux<Product> getProduct(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(x -> new Product(x, "product_"+x, x));
    }

    public Flux<Product> getProductWithError(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .take(4)
                .map(x->new Product(x, "product_"+x, x))
                .concatWith(Mono.fromRunnable(()->System.exit(1)));
    }

    public List<Product> getProducts(){

        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(x -> new Product(x, "product_"+x, x)).toStream().toList();
    }
}
