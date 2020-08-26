package com.apps.portal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.apps.portal.models.Employee;

@Service
public class EmployeeService {

	public Employee getEmployeeById(String empId) {
        Employee emp=getEmployeeFromMap(empId);
		return emp;
	}

	public Employee getEmployeeFromMap(String empId) {
		Map<String, Employee> empMap = new HashMap<String, Employee>();
		empMap.put("EMP001", new Employee("EMP001", "raja", 60000d));
		empMap.put("EMP002", new Employee("EMP001", "mani", 7000d));
		empMap.put("EMP003", new Employee("EMP001", "tom", 8000d));

		return empMap.get(empId);

	}
}
