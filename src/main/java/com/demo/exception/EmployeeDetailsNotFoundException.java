package com.demo.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class EmployeeDetailsNotFoundException extends RuntimeException{
    public EmployeeDetailsNotFoundException() {
        log.info("Unable to find the text");
    }
}
