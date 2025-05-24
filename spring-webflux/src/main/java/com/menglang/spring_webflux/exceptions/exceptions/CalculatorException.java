package com.menglang.spring_webflux.exceptions.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorException extends RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(CalculatorException.class);

    public CalculatorException(String msg) {
        super(msg);
        log.warn(" msg: {}",msg);
    }

}