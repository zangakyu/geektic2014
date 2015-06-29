package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekticDAO;
import com.ninja_squad.geektic.model.Geek;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Geektic Service
 * 
 * @author zangakyu
 */
@Service
@RestController
@Transactional
@RequestMapping("/api/geeks")
public class GeekticService {

	private GeekticDAO geekticDAO;

	@Autowired
	public GeekticService(GeekticDAO dao) {
		geekticDAO = dao;
	}

	@RequestMapping(method = GET)
	public List<Geek> getAllGeeks() {
		return geekticDAO.findAll();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Geek> getGeeksByInterest(@RequestParam("sexe") boolean sexe, @RequestParam("interest") String interestName) {
		return geekticDAO.findBySexeAndInterest(interestName, sexe);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Geek getGeekById(@PathVariable("id") Long id) {
		return geekticDAO.findById(id);
	}
}
