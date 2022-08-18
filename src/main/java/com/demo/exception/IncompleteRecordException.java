package com.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IncompleteRecordException extends RuntimeException{
    public IncompleteRecordException() {
        log.error("Data filled is incomplete");
    }
}
