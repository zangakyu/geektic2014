package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Interest;

@Repository
public class GeekticDAO {

	@PersistenceContext
	private EntityManager em;

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
	 * 
	 * @return A List of the Geeks
	 */
	public List<Geek> findAll() {
		String jpql = "SELECT g FROM Geek AS g";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.getResultList();
	}

	/**
	 * Returns a geek of the given Id
	 * 
	 * @param id The geek Id
	 */
	public Geek findById(int id) {
		return em.find(Geek.class, id);
	}

	/**
	 * Returns the geeks which sex and interest match
	 * 
	 * @param interest
	 */
	public List<Geek> findBySexAndInterest(String interestName, boolean sex) {

		// Get the interest
		String jpql = "SELECT i FROM Interest AS i WHERE lower(i.name) = :name";
		TypedQuery<Interest> interestQuery = em.createQuery(jpql, Interest.class);
		interestQuery.setParameter("name", interestName.toLowerCase());

		try {
			Interest interest = interestQuery.getSingleResult();

			// Search geeks which has this interest
			jpql = "SELECT g FROM Geek AS g WHERE g.sex=:sex AND :interest MEMBER OF g.interests";
			TypedQuery<Geek> geekQuery = em.createQuery(jpql, Geek.class);
			geekQuery.setParameter("interest", interest);
			geekQuery.setParameter("sex", sex);

			return geekQuery.getResultList();

		} catch (NoResultException ex) {
			return null;
		}	
	}
	
	/**
	 * Returns the geeks which interests contains the given string
	 * 
	 * @param interest
	 */
	public List<Geek> findByInterest(String interestName) {

		// Get the interest
		String jpql = "SELECT i FROM Interest AS i WHERE lower(i.name) = :name";
		TypedQuery<Interest> interestQuery = em.createQuery(jpql, Interest.class);
		interestQuery.setParameter("name", interestName.toLowerCase());

		try {
			Interest interest = interestQuery.getSingleResult();

			// Search geeks which has this interest
			jpql = "SELECT g FROM Geek AS g WHERE :interest MEMBER OF g.interests";
			TypedQuery<Geek> geekQuery = em.createQuery(jpql, Geek.class);
			geekQuery.setParameter("interest", interest);

			return geekQuery.getResultList();

		} catch (NoResultException ex) {
			return null;
		}	
	}

}
