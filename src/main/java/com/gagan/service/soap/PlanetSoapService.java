package com.gagan.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.gagan.model.PlanetVertex;
import com.gagan.service.PlanetService;

@WebService(endpointInterface = "com.gagan.soap.PlanetService")
public interface PlanetSoapService {

	@WebMethod
	public List<PlanetVertex> getAllPlanets() ;
	
	
}
