package com.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(Exception e) {
        log.info(String.valueOf(e), " Record not found!!");
    }
}
