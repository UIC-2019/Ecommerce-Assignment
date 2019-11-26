package com.example.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.EmployeeRegistration;
import com.example.beans.EmployeeWrapper;

@RestController
public class EmpRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value="/employees")
	  @ResponseBody
	  public List<EmployeeWrapper> getEmployees() {
	  return EmployeeRegistration.getInstance().getEmployeeRecords();
	  }

}
