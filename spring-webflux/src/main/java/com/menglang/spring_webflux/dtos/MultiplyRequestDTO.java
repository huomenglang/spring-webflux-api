package com.menglang.spring_webflux.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiplyRequestDTO {
    private int first ;
    private int second;

}
