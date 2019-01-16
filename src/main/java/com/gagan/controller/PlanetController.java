package com.gagan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gagan.model.PlanetVertex;
import com.gagan.service.PlanetService;
import com.gagan.util.Dijkstra;

@Controller
//@RequestMapping("/planetController")
public class PlanetController {

	@Autowired
	PlanetService planetService;

	@GetMapping("/")
	public String loginPage(){
		return "index";
	}
	
	@PostMapping("/findPath")
	public String findShortestPath(@RequestParam(value="source", required=true) String sourceNode,
			@RequestParam(value="destination", required=true) String destinationNode, Model model) {

		if (!StringUtils.isEmpty(sourceNode) && !StringUtils.isEmpty(destinationNode)){
			PlanetVertex srcNode = planetService.getPlanetVertexById(sourceNode);
			PlanetVertex destNode = planetService.getPlanetVertexById(destinationNode);
			
			model.addAttribute("result", Dijkstra.findShortestPath(srcNode, destNode));
		}
		
		return "index";
	}

}
