package com.apps.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps.portal.models.Employee;
import com.apps.portal.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	@RequestMapping(value = "/getemployee/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id){
		System.out.println("called ");
		Employee emp=empService.getEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
}
