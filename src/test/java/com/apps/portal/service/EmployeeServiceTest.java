package com.apps.portal.service;

import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import com.apps.portal.models.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeService.class)
public class EmployeeServiceTest {

	@SpyBean
	private EmployeeService service;
	
	@Test
	public void getEmpTest() {
		Employee emp=new Employee("EMP001", "raja", 60000d);
		doReturn(emp).when(service).getEmployeeFromMap(anyString());
		Employee employee = service.getEmployeeById("EMP001");
		assertEquals(emp.getEmpName(), "raja");
	}
}
