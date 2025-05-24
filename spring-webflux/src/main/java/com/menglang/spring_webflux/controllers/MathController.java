package com.menglang.spring_webflux.controllers;

import com.menglang.spring_webflux.dtos.MultiplyRequestDTO;
import com.menglang.spring_webflux.dtos.response.ResponseDTO;
import com.menglang.spring_webflux.services.multiply.MultiplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/math")
@RequiredArgsConstructor
@Slf4j
public class MathController {

    private final MultiplyService multiplyService;

    @GetMapping("/greeting")
    public Mono<String> multiply() {
        log.info("execute.........");
        return Mono.just("Hello...");
    }

    @PostMapping("/multiply")
    public Mono<ResponseDTO> multiplyController(@RequestBody Mono<MultiplyRequestDTO> dto, @RequestHeader Map<String, String> reqHeader) {
        log.info("controller service.......{} ", reqHeader.get("api-key-header"));
        return multiplyService.multiply(dto);
    }

    @GetMapping("/multiply-extract/{value}")
    public Mono<ResponseDTO> multiplyExtract(@PathVariable Integer value, @RequestHeader Map<String, String> reqHeader) {
        log.info("controller service .......{} ", reqHeader.get("api-key-header"));
//        return Mono.just("HELLo................");
        return multiplyService.findMultiplyExtract(value);
    }

}
