package com.piseth.java.school.webflux_playgroud.session1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    private Integer id;
    private String name;
    private String email;
}