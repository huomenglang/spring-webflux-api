package com.menglang.spring_webflux.dtos.response;

import lombok.Builder;

@Builder
public record ResponseDTO(String id, Integer price){}