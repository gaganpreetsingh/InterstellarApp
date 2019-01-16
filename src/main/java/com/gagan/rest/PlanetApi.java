package com.gagan.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagan.model.PlanetVertex;
import com.gagan.service.EdgeService;
import com.gagan.service.PlanetService;


@RestController
@RequestMapping("/planetApi")
public class PlanetApi {

	@Autowired
	PlanetService planetService;
	@Autowired
	EdgeService edgeService;

	@GetMapping("/allPlanets")
	public List<PlanetVertex> getAllPlanets() {
		return planetService.getAllPlanets();
	}

	@PostMapping("/savePlanet")
	public void createPlanetNode(@Valid @RequestBody PlanetVertex planet) {
		planetService.createPlanetNode(planet);
	}

	@GetMapping("/planet/{id}")
	public PlanetVertex getNodeById(@PathVariable(value = "id") String planetNode) {
		return planetService.getPlanetVertexById(planetNode);
	}
	
	@DeleteMapping("/planet/{id}")
	public void deleteNode(@PathVariable(value = "id") String planetNode){
		PlanetVertex planetVertex = this.getNodeById(planetNode);
		edgeService.deleteReferences(planetVertex);
		if(planetVertex!=null){
			planetService.deleteNode(planetNode);
		}	
	}
}
