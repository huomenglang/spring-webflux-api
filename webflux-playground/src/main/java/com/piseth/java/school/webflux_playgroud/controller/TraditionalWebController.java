package com.piseth.java.school.webflux_playgroud.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.piseth.java.school.webflux_playgroud.dto.Product;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/traditional")
@Slf4j
public class TraditionalWebController {
	
	private final RestClient restClient = RestClient
			.builder()
			.baseUrl("http://localhost:8080")
			.build();

	@GetMapping("/greeting")
	public String greeting(){
		return "Greeting From External.....";
	}

	@GetMapping("/products")
	public List<Product> getProducts(){
		log.info("Received Request......");
		var list = this.restClient.get()
			.uri("/products/sample")
//			.uri("/products/black")
			.retrieve()
			.body(new ParameterizedTypeReference<List<Product>>() {
			});
		log.info("Received Response: {}", list);
		return list;
	}
	

	
	

}
