package com.gagan.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagan.dao.EdgeRepository;
import com.gagan.model.Edge;
import com.gagan.model.PlanetVertex;

@Service
public class EdgeService {

	@Autowired
	EdgeRepository edgeRepository;
		
	public void deleteEdge(String planetNode) {
		edgeRepository.delete(planetNode);
	}
	
	public void deleteReferences(PlanetVertex planetNode) {
		List<Edge> childEdges =edgeRepository.getPlanetVertexReferences(planetNode);
		deleteChildEdges(childEdges);
	}
	
	public void deleteChildEdges(Collection<Edge> c) {
		edgeRepository.delete(c);
	}
}
