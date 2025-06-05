package com.piseth.java.school.webflux_playgroud.repository;

import com.piseth.java.school.webflux_playgroud.session1.Customer;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {


    Flux<Customer> findByName(String name);
}
