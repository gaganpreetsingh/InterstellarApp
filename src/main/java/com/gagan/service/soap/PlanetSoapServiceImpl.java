package com.gagan.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.gagan.dao.PlanetVertexRepository;
import com.gagan.model.PlanetVertex;
import com.gagan.service.PlanetService;

@WebService(endpointInterface = "com.gagan.service.soap.PlanetSoapService")
public class PlanetSoapServiceImpl implements PlanetSoapService {

	@Autowired
	PlanetVertexRepository planetVertexRepository;
	
	@WebMethod
	public List<PlanetVertex> getAllPlanets() {
		return (List<PlanetVertex>)planetVertexRepository.findAll();
	}
	
}
