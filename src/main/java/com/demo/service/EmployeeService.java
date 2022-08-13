package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> getAll() {
		return employeeDao.findAll();
	}

	/*public List<Employee> getById(Long id) {
		return employeeDao.findAllById(Collections.singleton(id));
	}*/

	/*public List<Employee> save() {

	}

	public List<Employee> delete() {

	}*/
}
