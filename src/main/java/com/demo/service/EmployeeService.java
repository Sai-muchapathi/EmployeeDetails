package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> getAll() {
		return employeeDao.findAll();
	}

	public Optional<Employee> getById(long id) {
		return employeeDao.findById(id);
	}

	/*public List<Employee> save() {

	}

	public List<Employee> delete() {

	}*/
}
