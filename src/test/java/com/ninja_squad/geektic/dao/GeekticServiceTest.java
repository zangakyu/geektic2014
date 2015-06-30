package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.service.GeekticService;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class GeekticServiceTest {
	
	public GeekticService geekticService ;
	public GeekticDAO mockedDAO;
	@Before
	public void before(){
		mockedDAO = mock(GeekticDAO.class);
		geekticService = new GeekticService(mockedDAO);
	}
	
	@Test
	public void getAllGeeks(){
		List<Geek> geeks = new ArrayList<Geek>();
		
		Geek geek = new Geek();
		geek.setAge(12);
		geek.setFirstName("Castiel");
		geek.setLastName("Angel");
		
		geeks.add(geek);
		
		when(mockedDAO.findAll()).thenReturn(geeks);
		
		assertEquals(geeks,mockedDAO.findAll());
		assertEquals(geek, geeks.get(0));
		
	}
	
	@Test
	public void getGeeksByInterestAndSexe(){
		List<Geek> geeks = new ArrayList<Geek>();
		
		Geek geek = new Geek();
		geek.setAge(12);
		geek.setFirstName("Castiel");
		geek.setLastName("Angel");
		geek.setSex(true);
		
		geeks.add(geek);
		
		when(mockedDAO.findBySexAndInterest("java", true)).thenReturn(geeks);
		
		assertEquals(geeks,mockedDAO.findBySexAndInterest("java", true));
		assertEquals(geek, geeks.get(0));
	}

}
