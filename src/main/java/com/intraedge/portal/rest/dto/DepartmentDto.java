package com.intraedge.portal.rest.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="Department")
@XmlType( propOrder={ "id", "name", "description", "employees", "audit"} )
public class DepartmentDto {
	private int id;
	private String name;
	private String description;
	private List<EmployeeDto> employees;
	private AuditDto audit;
	
	public DepartmentDto(){
		
	}
	
	public AuditDto getAudit() {
		return audit;
	}
	public void setAudit(AuditDto audit) {
		this.audit = audit;
	}
	public int getId() {
		return id;
	}
	public List<EmployeeDto> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
