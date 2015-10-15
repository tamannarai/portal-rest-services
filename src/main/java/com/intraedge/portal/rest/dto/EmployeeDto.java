package com.intraedge.portal.rest.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Employee")
@XmlType( propOrder={ "id", "firstName", "lastName", "email", "joinDate", "audit", "department"} )
public class EmployeeDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Date joinDate;
	private DepartmentDto department;
	private AuditDto audit;
	
	public AuditDto getAudit() {
		return audit;
	}
	public void setAudit(AuditDto audit) {
		this.audit = audit;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DepartmentDto getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}
	
}
