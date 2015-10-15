package com.intraedge.portal.rest.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intraedge.portal.rest.dao.EmployeeDao;
import com.intraedge.portal.rest.dto.EmployeeDto;
import com.intraedge.portal.rest.dto.builder.DtoToEntityBuilder;
import com.intraedge.portal.rest.dto.builder.EntityToDtoBuilder;
import com.intraedge.portal.rest.entity.EmployeeEntity;
import com.intraedge.portal.rest.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(EmployeeDto employeeDto) {		
		EmployeeEntity employeeEntity = (EmployeeEntity)DtoToEntityBuilder.build(employeeDto);
		return employeeDao.save(employeeEntity);
	}

	@Transactional(readOnly=true)
	@Override	
	public EmployeeDto findById(int id) {
		EmployeeEntity employeeEntity =  employeeDao.findById(id);
		return (EmployeeDto)EntityToDtoBuilder.build(employeeEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAll() {		
		List<EmployeeEntity> employeeEntityList = employeeDao.findAll();
		List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		for(EmployeeEntity entity: employeeEntityList){
			employeeDtoList.add((EmployeeDto)EntityToDtoBuilder.build(entity));
		}
		return employeeDtoList;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = (EmployeeEntity)DtoToEntityBuilder.build(employeeDto);
		return employeeDao.update(employeeEntity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = (EmployeeEntity)DtoToEntityBuilder.build(employeeDto);
		employeeDao.delete(employeeEntity);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}

}
