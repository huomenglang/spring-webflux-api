package com.menglang.spring_webflux.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.function.UnaryOperator;

public class Transformer {

    private static final Logger log = LoggerFactory.getLogger(Transformer.class);

    public static <T> UnaryOperator<Flux<T>> fluxLogger(String path) {
        return flux -> flux
                .doFirst(() -> log.info("Receive: " + path ))
                .doOnCancel(() -> log.info("Cancel: " + path))
                .doOnComplete(() -> log.info("OnComplete: " + path));
    }
}
