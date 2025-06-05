package com.piseth.java.school.webflux_playgroud.session1;


import org.springframework.data.relational.core.mapping.Table;

@Table(name = "product")
public class Product {
    private Integer id;
    private String description;
    private Double price;
}
