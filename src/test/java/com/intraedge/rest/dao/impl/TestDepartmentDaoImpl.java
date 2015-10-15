/**
 * 
 */
package com.intraedge.rest.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intraedge.portal.rest.dao.DepartmentDao;
import com.intraedge.portal.rest.dto.DepartmentDto;

/**
 * @author akumar1
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestDepartmentDaoImpl {

	@Autowired
	DepartmentDao departmentDao;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before carring out tests");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Tests Completed");
	}

	/**
	 * Test method for {@link com.intraedge.portal.rest.dao.impl.DepartmentDaoImpl#save(com.intraedge.portal.rest.dto.DepartmentDto)}.
	 */
	@Test
	public void testSave() {
		/*DepartmentDto department = new DepartmentDto();
		department.setDescription("TEST");
		department.setName("Test Department");
		departmentDao.save(department);
		List<DepartmentDto> departments = departmentDao.findAll();
		System.out.println(departments.size());*/
	}

	/**
	 * Test method for {@link com.intraedge.portal.rest.dao.impl.DepartmentDaoImpl#find(int)}.
	 */
	@Test
	public void testFind() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.intraedge.portal.rest.dao.impl.DepartmentDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.intraedge.portal.rest.dao.impl.DepartmentDaoImpl#update(com.intraedge.portal.rest.dto.DepartmentDto)}.
	 */
	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.intraedge.portal.rest.dao.impl.DepartmentDaoImpl#delete(com.intraedge.portal.rest.dto.DepartmentDto)}.
	 */
	@Test
	public void testDeleteDepartmentDto() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.intraedge.portal.rest.dao.impl.DepartmentDaoImpl#delete(int)}.
	 */
	@Test
	public void testDeleteInt() {
		//fail("Not yet implemented");
	}

}
