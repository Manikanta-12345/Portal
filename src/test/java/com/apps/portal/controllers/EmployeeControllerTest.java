package com.apps.portal.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.Matchers.anyString;
import com.apps.portal.models.Employee;
import com.apps.portal.service.EmployeeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private EmployeeService empService;
	@Before
	public void setUp() {
		DefaultMockMvcBuilder webAppContextSetup = MockMvcBuilders.webAppContextSetup(context);
		mockMvc=webAppContextSetup.build();
	}
	@Test
	public void getEmpById() throws Exception {
		String actual="{\"empId\":\"EMP001\",\"empName\":\"raja\",\"empSalary\":60000.0}";
		Employee emp=new Employee("EMP001", "raja", 60000d);
		when(empService.getEmployeeById(anyString())).thenReturn(emp);
		String empId="EMP001";
		MvcResult result = mockMvc.perform(get("/employee/getemployee/"+empId)).andExpect(status().isOk()).andReturn();
		System.out.println("res "+result.getResponse().getContentAsString());
	    JSONAssert.assertEquals(result.getResponse().getContentAsString(), actual, true);
	}
}
