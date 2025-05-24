package com.piseth.java.school.webflux_playgroud.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.piseth.java.school.webflux_playgroud.dto.Product;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("reactive")
@Slf4j
public class ReactiveWebController {
	
	private final WebClient webClient = WebClient
			.builder()
			.baseUrl("http://localhost:8080")
			.build();
	
	@GetMapping("products")
	public Flux<Product> getProducts(){
		log.info("receive request: ...");
		return this.webClient.get()
			.uri("products")
			.retrieve()
			.bodyToFlux(Product.class)
//				.onErrorComplete()
			.doOnNext(x -> log.info("Received: " + x));
			
	}
	
	@GetMapping(value = "products/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getProductsStream(){
		return this.webClient.get()
			//.uri("/demo001/products")
			.uri("products")
			.retrieve()
			.bodyToFlux(Product.class)
			.doOnNext(x -> log.info("Received: " + x));
			
	}

	@GetMapping(value = "products/error", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getProductsStreamError(){
		return this.webClient.get()
				.uri("products/error")
				.retrieve()
				.bodyToFlux(Product.class)
				.onErrorComplete()
				.doOnNext(x -> log.info("Received: " + x));

	}
	
	

}
