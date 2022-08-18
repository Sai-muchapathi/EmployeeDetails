package com.demo.controller;

import com.demo.exception.EmployeeDetailsNotFoundException;
import com.demo.exception.IncompleteRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class EmployeeController extends EmployeeDetailsNotFoundException {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<?> getAll() {
		log.info("Inside getResult method");
		log.info("Printing employee details");
		return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
	}

	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getById(@PathVariable final long id) {
		Optional<Employee> employee = employeeService.getById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		}
		else {
			throw new EmployeeDetailsNotFoundException();
		}
	}

	@PostMapping(path = "employee",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployeeDetails(@RequestBody final Employee newEmployee) {
		Employee createEmployeeRecord = employeeService.save(newEmployee);
		if(createEmployeeRecord == null) {
			throw new IncompleteRecordException();
		}
		else {
			log.info("New record inserted");
			log.info(String.valueOf(createEmployeeRecord));
			return new ResponseEntity<>(createEmployeeRecord, HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public HttpStatus deleteEmployeeDetails(@PathVariable final long id) {
		try {
			employeeService.delete(id);
			log.info("Record deleted");
			return HttpStatus.OK;
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}
	}
}
