package com.restapijrsy.jerseydata;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	int empId;
	String empName;
	String empLocation;
		
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	

}
