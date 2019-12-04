package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Employee;
import com.example.beans.EmployeeRegistration;
import com.example.beans.EmployeeWrapper;


@CrossOrigin(origins= "http://localhost:8085")
@RestController
public class EmpRegistrationController {

	@RequestMapping(method = RequestMethod.POST, value="/register/employee")
	  @ResponseBody
	  public EmployeeWrapper registerEmployee(@RequestBody EmployeeWrapper emp) {
		  System.out.println("In registerStudent");
		  EmployeeWrapper empResp= new EmployeeWrapper();
		  Employee employee = new Employee();
		  EmployeeRegistration.getInstance().add(emp);
	        
		  employee.setName(emp.getEmployee().getName());
		  employee.setAge(emp.getEmployee().getAge());
		  employee.setEmpId(emp.getEmployee().getEmpId());
		  employee.setDepartment(emp.getEmployee().getDepartment());
		  employee.setStatus("Successful");
		  empResp.setEmployee(employee);
	      return empResp;
	}
}
