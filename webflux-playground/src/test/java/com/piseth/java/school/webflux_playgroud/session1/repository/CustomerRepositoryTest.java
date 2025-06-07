package com.piseth.java.school.webflux_playgroud.session1.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.piseth.java.school.webflux_playgroud.repository.CustomerRepository;
import com.piseth.java.school.webflux_playgroud.session1.AbstractTest;
import com.piseth.java.school.webflux_playgroud.session1.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void testFindByName(){
        log.info("Start Testing findByName.....");
       customerRepository.findByName("sophia")
               .as(StepVerifier::create)
               .assertNext(t->Assertions.assertEquals("sophia@example.com",t.getEmail()))
               .expectComplete()
               .verify();

    }



    @Test
    void findByNameStartingWith(){
        log.info("start testing with starting with.");
        customerRepository.findByNameStartingWith("e")
                .doOnNext(t->log.info("--------------------->>Receive {}",t))
                .as(StepVerifier::create)
                .assertNext(t->Assertions.assertEquals("emily",t.getName()))
                .assertNext(t->Assertions.assertEquals("ethan",t.getName()))
                .expectComplete()
                .verify();
    }

    @BeforeEach
    void setupEnvironment(){
        //clear all data

        //insert new data
    }



    @Test
    void insertAndDeleteCustomer() {
        Customer customer = new Customer();
        customer.setEmail("menglang@gmail.com");
        customer.setName("menglang");


        //Insert
        customerRepository.save(customer)
                .doOnNext(t -> log.info("insert data: {}", t.getName()))
                .as(StepVerifier::create)
                .assertNext(t -> {
                    Assertions.assertNotNull(t.getId());
                    Assertions.assertEquals("menglang", t.getName());
                    Assertions.assertEquals("menglang@gmail.com", t.getEmail());
                })
                .expectComplete()
                .verify();

        customerRepository.count()
                .as(StepVerifier::create)
                .assertNext(count -> Assertions.assertEquals(11, count)) // make sure 11 is expected
                .expectComplete()
                .verify();

        //delete
        customerRepository.deleteById(11)
                .then(customerRepository.count())
                .as(StepVerifier::create)
                .assertNext(t->Assertions.assertEquals(10,t))
                .expectComplete()
                .verify();

    }

    @Test
    void UpdateCustomer(){

        customerRepository.findById(4)
                .doOnNext(t->{
                    log.info("---------------------------> log data: {}",t.getEmail());
                    t.setName("nirodey");
                    t.setEmail("nirodey@gmail.com");
                }).flatMap(t->customerRepository.save(t))
                .as(StepVerifier::create)
                .assertNext(t-> {
                    Assertions.assertEquals("nirodey",t.getName());
                    Assertions.assertEquals("nirodey@gmail.com",t.getEmail());
                })
                .expectComplete()
                .verify() ;

    }


}
