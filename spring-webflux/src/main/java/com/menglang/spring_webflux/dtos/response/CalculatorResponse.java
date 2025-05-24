package com.menglang.spring_webflux.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorResponse {
    private int first;
    private int second;
    private String operation;
    private double result;
}
