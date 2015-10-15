package com.intraedge.portal.rest.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.intraedge.portal.rest.dto.DepartmentDto;
import com.intraedge.portal.rest.dto.EmployeeDto;
import com.intraedge.portal.rest.entity.DepartmentEntity;
import com.intraedge.portal.rest.entity.EmployeeEntity;

public class DtoToEntityBuilder {
	public static Object build(Object object) {
		if (object instanceof DepartmentDto) {
			DepartmentDto departmentDto = (DepartmentDto) object;
			DepartmentEntity departmentEntity = new DepartmentEntity();
			departmentEntity.setId(departmentDto.getId());
			departmentEntity.setName(departmentDto.getName());
			departmentEntity.setDescription(departmentDto.getDescription());
			List<EmployeeEntity> employeeEntityList = new ArrayList<EmployeeEntity>();
			if(departmentDto.getEmployees() != null){
				for (EmployeeDto employeeDto : departmentDto.getEmployees()) {
					EmployeeEntity employeeEntity = (EmployeeEntity)build(employeeDto);
					employeeEntity.setDepartment(departmentEntity);
					employeeEntityList.add(employeeEntity);
				}
			}
			departmentEntity.setEmployees(employeeEntityList);
			return departmentEntity;

		} else if (object instanceof EmployeeDto) {
			EmployeeDto employeeDto = (EmployeeDto) object;
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setId(employeeDto.getId());
			employeeEntity.setFirstName(employeeDto.getFirstName());
			employeeEntity.setLastName(employeeDto.getLastName());
			employeeEntity.setEmail(employeeDto.getEmail());
			employeeEntity.setJoinDate(employeeDto.getJoinDate());
			DepartmentDto departmentDto = employeeDto.getDepartment();
			if(departmentDto!=null){
				DepartmentEntity departmentEntity = new DepartmentEntity();
				departmentEntity.setId(departmentDto.getId());
				departmentEntity.setName(departmentDto.getName());
				departmentEntity.setDescription(departmentDto.getDescription());
				employeeEntity.setDepartment(departmentEntity);
			}
			return employeeEntity;

		}
		return null;
	}
}
