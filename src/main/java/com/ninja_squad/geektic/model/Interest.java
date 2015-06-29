package com.ninja_squad.geektic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Interest {
	
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "INTERESTID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;
	
	private String name;
	
	public Interest(){
	}
	
	public int getId() {
		return id;
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

}
