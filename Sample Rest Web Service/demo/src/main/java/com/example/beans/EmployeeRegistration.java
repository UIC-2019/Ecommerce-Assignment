package com.example.beans;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistration {
	
	private List<EmployeeWrapper> employeeRecords;
    private static EmployeeRegistration empregd = null;
    private EmployeeRegistration(){
    	employeeRecords = new ArrayList<EmployeeWrapper>();
    }
    public static EmployeeRegistration getInstance() {
        if(empregd == null) {
        	empregd = new EmployeeRegistration();
              return empregd;
            }
            else {
                return empregd;
            }
    }
    public void add(EmployeeWrapper emp) {
    employeeRecords.add(emp);
    }

    public List<EmployeeWrapper> getEmployeeRecords() {
    return employeeRecords;
    }

}
