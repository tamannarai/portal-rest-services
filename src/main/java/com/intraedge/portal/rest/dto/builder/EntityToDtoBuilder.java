package com.intraedge.portal.rest.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.intraedge.portal.rest.dto.AuditDto;
import com.intraedge.portal.rest.dto.DepartmentDto;
import com.intraedge.portal.rest.dto.EmployeeDto;
import com.intraedge.portal.rest.entity.AuditEntity;
import com.intraedge.portal.rest.entity.DepartmentEntity;
import com.intraedge.portal.rest.entity.EmployeeEntity;

public class EntityToDtoBuilder {
	public static Object build(Object object) {
		if (object instanceof DepartmentEntity) {
			DepartmentEntity departmentEntity = (DepartmentEntity) object;
			DepartmentDto departmentDto = new DepartmentDto();
			departmentDto.setId(departmentEntity.getId());
			departmentDto.setName(departmentEntity.getName());
			departmentDto.setDescription(departmentEntity.getDescription());
			//Work on employee list
			List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
			for (EmployeeEntity empEntity : departmentEntity.getEmployees()) {
				EmployeeDto empoyeedto = (EmployeeDto) build(empEntity);
				employeeDtoList.add(empoyeedto);
			}
			departmentDto.setEmployees(employeeDtoList);
			if(departmentEntity.getAuditEntity() != null){
				AuditDto auditDto = (AuditDto) build(departmentEntity.getAuditEntity());
				departmentDto.setAudit(auditDto);
			}
			return departmentDto;

		} else if (object instanceof EmployeeEntity) {
			EmployeeEntity employeeEntity = (EmployeeEntity) object;
			EmployeeDto employeeDto = new EmployeeDto();

			employeeDto.setId(employeeEntity.getId());
			employeeDto.setFirstName(employeeEntity.getFirstName());
			employeeDto.setLastName(employeeEntity.getLastName());
			employeeDto.setEmail(employeeEntity.getEmail());
			employeeDto.setJoinDate(employeeEntity.getJoinDate());

			if (employeeEntity.getDepartment() != null) {
				DepartmentEntity departmentEntity = (DepartmentEntity) employeeEntity.getDepartment();
				DepartmentDto departmentDto = new DepartmentDto();
				departmentDto.setId(departmentEntity.getId());
				departmentDto.setName(departmentEntity.getName());
				departmentDto.setDescription(departmentEntity.getDescription());
				employeeDto.setDepartment(departmentDto);
			}
			if(employeeEntity.getAuditEntity() != null){
				AuditDto auditDto = (AuditDto) build(employeeEntity.getAuditEntity());
				employeeDto.setAudit(auditDto);
			}
			return employeeDto;

		} else if (object instanceof AuditEntity) {
			AuditEntity auditEntity = (AuditEntity) object;
			AuditDto auditDto = new AuditDto();

			auditDto.setCreatedBy(auditEntity.getCreatedBy());
			auditDto.setCreatedDate(auditEntity.getCreatedDate());
			auditDto.setUpdatedBy(auditEntity.getUpdatedBy());
			auditDto.setUpdatedDate(auditEntity.getUpdatedDate());
			return auditDto;

		} 
		return null;
	}
}
