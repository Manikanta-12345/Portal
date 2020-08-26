package com.apps.portal.models;

public class Employee {

	private String empId;
	private String empName;
	private Double empSalary;

	public Employee(String empId, String empName, Double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

}
