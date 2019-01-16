package com.gagan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagan.dao.PlanetVertexRepository;
import com.gagan.model.PlanetVertex;

@Service
public class PlanetService {

	@Autowired
	PlanetVertexRepository planetVertexRepository;

	public List<PlanetVertex> getAllPlanets() {
		return (List<PlanetVertex>)planetVertexRepository.findAll();
	}

	public void createPlanetNode(PlanetVertex planet) {
		planetVertexRepository.save(planet);
	}

	public PlanetVertex getPlanetVertexById(String planetNode) {
		return planetVertexRepository.findOne(planetNode);
	}
	
	public void deleteNode(String planetNode) {
		PlanetVertex pl = planetVertexRepository.findOne(planetNode);
		planetVertexRepository.delete(planetNode);
	}
}
