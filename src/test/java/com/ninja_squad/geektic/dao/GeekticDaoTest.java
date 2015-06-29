package com.ninja_squad.geektic.dao;

import java.util.List;


import com.ninja_squad.geektic.model.Geek;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
/**
 * This is example code for a DAO test.
 * 
 * @author JB Nizet
 */
public class GeekticDaoTest extends BaseDaoTest {

	@Autowired
	private GeekticDAO dao;

	@Test
	public void findAllTest() {
		List<Geek> geeks = dao.findAll();
		assertEquals(7, geeks.size());
	}
}
