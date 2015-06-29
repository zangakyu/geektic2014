package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Interest;

public class GeekticDAO {
	private EntityManager em;

	public GeekticDAO(EntityManager em) {
		this.em = em;
	}

	/**
	 * Persists a new Geek
	 * 
	 * @param geek
	 */
	public void persist(Geek geek) {
		em.persist(geek);
	}

	/**
	 * Returns all Geeks
	 * @return A List of the Geeks
	 */
	public List<Geek> findAll() {
		String jpql = "SELECT g FROM Geek AS g";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.getResultList();
	}

	/**
	 * Returns a geek of the given Id
	 * @param id The geek Id
	 */
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}

	/**
	 * Returns the geeks which interests contains the given string
	 * @param interest
	 */
	public List<Geek> findByInterest(String interestName) {
		
		//Get the interest
		String jpql = "SELECT i FROM Interest WHERE i.name  LIKE '%:name%'";
		TypedQuery<Interest> interestQuery = em.createQuery(jpql, Interest.class);
		interestQuery.setParameter("name", interestName);
		
		Interest interest = interestQuery.getSingleResult();
		
		
		jpql = "SELECT g FROM Geek AS g WHERE :interest MEMBER OF g.interests";
		TypedQuery<Geek> geekQuery = em.createQuery(jpql, Geek.class);
		geekQuery.setParameter("interest", interest);
		return geekQuery.getResultList();
	}

}
