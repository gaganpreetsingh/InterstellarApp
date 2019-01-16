package com.gagan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gagan.model.Edge;
import com.gagan.model.PlanetVertex;

public interface EdgeRepository extends CrudRepository<Edge, String>{

	@Query("from Edge e where e.nextVertex=?1 or e.parentVertex=?1")
	public List<Edge> getPlanetVertexReferences(PlanetVertex node);
}
