package com.menglang.spring_webflux.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class StatusResponse {
        private short code;
        private LocalDateTime timestamp;
        private String message;
}
