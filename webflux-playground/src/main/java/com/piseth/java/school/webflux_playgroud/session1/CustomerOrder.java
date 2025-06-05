package com.piseth.java.school.webflux_playgroud.session1;

import jakarta.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    private String uuid;
    private Integer customerId;
    private Integer productId;
    private Integer amount;
}
