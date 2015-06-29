package com.ninja_squad.geektic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Geek {
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "GEEKID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;
	
	private String lastName;
	private String FirstName;
	private int age;
	private boolean sexe;
	private String mail;
	
	@ManyToMany
	@JoinTable(
		      name="GEEKINTEREST",
		      joinColumns={@JoinColumn(name="GEEKID", referencedColumnName="ID")},
		      inverseJoinColumns={@JoinColumn(name="INTERESTID", referencedColumnName="ID")})
	private List<Interest> interest;
	
	public Geek(){	
	}
	
	/* Getters and setters */	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSexe() {
		return sexe;
	}
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Interest> getInterest() {
		return interest;
	}

	public void setInterest(List<Interest> interest) {
		this.interest = interest;
	}
	
	

}
