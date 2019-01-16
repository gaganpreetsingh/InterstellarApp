package com.gagan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gagan.model.PlanetVertex;

public interface PlanetVertexRepository extends CrudRepository<PlanetVertex, String>{

}
