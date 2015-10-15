package com.intraedge.portal.rest.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intraedge.portal.rest.dao.DepartmentDao;
import com.intraedge.portal.rest.entity.AuditEntity;
import com.intraedge.portal.rest.entity.DepartmentEntity;
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int save(DepartmentEntity departmentEntity) {
		Session session = sessionFactory.openSession();
		AuditEntity auditEntity = new AuditEntity();
		auditEntity.setCreatedBy("System");
		auditEntity.setCreatedDate(new Date());
		departmentEntity.setAuditEntity(auditEntity);
		session.save(departmentEntity);
		
		return departmentEntity.getId();
	}

	@Override
	public DepartmentEntity findById(int id) {
		Session session = sessionFactory.openSession();
		DepartmentEntity departmentEntity=(DepartmentEntity)session.get(DepartmentEntity.class, id);
		return departmentEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentEntity> findAll() {
		Session session = sessionFactory.openSession();
		Query query= (Query) session.createQuery("from DepartmentEntity");
		List<DepartmentEntity> departmentEntityList= (List<DepartmentEntity>)query.list();
		return departmentEntityList;
	}

	@Override
	public int update(DepartmentEntity departmentEntity) {
		AuditEntity auditEntity = new AuditEntity();
		auditEntity.setUpdatedBy("System");
		auditEntity.setUpdatedDate(new Date());
		departmentEntity.setAuditEntity(auditEntity);
		Session session = sessionFactory.openSession();
		session.merge(departmentEntity);
		return departmentEntity.getId();
	}

	@Override
	public void delete(DepartmentEntity departmentEntity) {
		Session session = sessionFactory.openSession();
		session.delete(departmentEntity);
		session.flush();
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.openSession();
		DepartmentEntity departmentEntity = (DepartmentEntity) session.get(DepartmentEntity.class, id);
		session.delete(departmentEntity);
		session.flush();
	}
}
