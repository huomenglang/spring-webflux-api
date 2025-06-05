package com.piseth.java.school.webflux_playgroud.session1.repository;

import com.piseth.java.school.webflux_playgroud.repository.CustomerRepository;
import com.piseth.java.school.webflux_playgroud.session1.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

@Slf4j
public class CustomerRepositoryTest extends AbstractTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindAll(){
        log.info("Start TEsting.....");
        customerRepository.findAll();
        StepVerifier.create(customerRepository.findAll())
                .expectNextCount(10)
                .expectComplete()
                .verify();
    }

    @Test
    void testFindAll2(){
        log.info("Start Teting.....");
        customerRepository.findAll();
        StepVerifier.create(customerRepository.findAll())
                .consumeNextWith(t->{
                    Assertions.assertEquals("sam",t.getName());
                })
                .expectNextCount(9)
                .expectComplete()
                .verify();
    }

//    @Test
//    void testFindAll2(){
//        log.info("Start Teting.....");
//        customerRepository.findAll();
//        StepVerifier.create(customerRepository.findAll())
//                .consumeNextWith(t->{
//                    Assertions.assertEquals("sam",t.getName());
//                })
//                .expectNextCount(9)
//                .expectComplete()
//                .verify();
//    }

}
