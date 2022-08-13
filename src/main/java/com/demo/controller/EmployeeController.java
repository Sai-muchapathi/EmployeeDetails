package com.demo.controller;

import com.demo.exception.EmployeeDetailsNotFoundException;
import com.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	/*@GetMapping("users/{id}")
	public ResponseEntity<Employee> getById(@PathVariable final long id) {
		Optional<Employee> user = employeeService.getById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		}
		else {
			throw new EmployeeDetailsNotFoundException();
		}
	}*/
}
