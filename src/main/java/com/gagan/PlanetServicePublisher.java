package com.gagan;

import javax.xml.ws.Endpoint;

import com.gagan.service.soap.PlanetSoapServiceImpl;

public class PlanetServicePublisher {

	public static void main(String[] args) {
 
        Endpoint.publish("http://localhost:9090/planetService", 
          new PlanetSoapServiceImpl());
    }

}
