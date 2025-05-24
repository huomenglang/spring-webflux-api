package com.menglang.spring_webflux.services.multiply;

import com.menglang.spring_webflux.dtos.MultiplyRequestDTO;
import com.menglang.spring_webflux.dtos.response.ResponseDTO;
import com.menglang.spring_webflux.exceptions.exceptions.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MultiplyService {

    private static final Logger log = LoggerFactory.getLogger(MultiplyService.class);

    public Mono<ResponseDTO> multiply(Mono<MultiplyRequestDTO> multiMono) {

        log.info("service execute........ ");
        return multiMono.map(x -> ResponseDTO.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .price(x.getFirst() * x.getSecond())
                .build());
    }

    public Mono<ResponseDTO> findMultiplyExtract(Integer input) {

        log.info("service executing........ ");
        return Mono.fromSupplier(() -> input)
                .handle((num, sink) -> {
                    if(num<10 || num>20){
                        sink.error(new CalculatorException("Number input out of Range from 10-20"));
                    }else {
                        sink.next(ResponseDTO.builder()
                                .id(UUID.randomUUID().toString())
                                .price(Math.multiplyExact(input,input))
                                .build());
                    }
                });


    }


}
