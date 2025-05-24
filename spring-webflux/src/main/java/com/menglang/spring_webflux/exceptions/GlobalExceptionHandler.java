package com.menglang.spring_webflux.exceptions;

import com.menglang.spring_webflux.dtos.response.BaseResponse;
import com.menglang.spring_webflux.exceptions.exceptions.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CalculatorException.class)
    public  ResponseEntity<BaseResponse> handleCalculateException(CalculatorException e) {
        log.warn("calculate exceptions: {}", e.getMessage());
        return BaseResponse.failed(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
