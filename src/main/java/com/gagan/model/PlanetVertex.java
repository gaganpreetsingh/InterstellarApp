package com.gagan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="planet_vertex")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="planetNode")
public class PlanetVertex implements Comparable<PlanetVertex> {
	 
	@Id
	@Column(name="node")
	private String planetNode;
	
	@Column(name="planet_name")
	private String planetName;
	
	@JsonProperty("adjacenctNodes")
	@OneToMany(mappedBy="parentVertex", cascade=CascadeType.ALL, orphanRemoval = true)
	@Column(name="adjacencies")
	private List<Edge> adjacencies;
	
	@OneToOne
	@JsonProperty("prevVertex")
	@JoinColumn(name="prev_node")
	private PlanetVertex predecessor;
	
	@Transient
	private double distance=Double.MAX_VALUE;
 
	public PlanetVertex(){
		
	}
	public PlanetVertex(String name) {
		this.planetNode = name;
		this.adjacencies = new ArrayList<>();
	}
 
	public void removeEdge(Edge edge){
		adjacencies.remove(edge);
		edge.setParentVertex(null);
		edge.setNextVertex(null);
	}
	
	public void addNeighbour(Edge edge) {
		this.adjacencies.add(edge);
	}
 
	public List<Edge> getAdjacencies() {
		return adjacencies;
	}
	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}
	public PlanetVertex getPredecessor() {
		return predecessor;
	}
 
	public void setPredecessor(PlanetVertex predecessor) {
		this.predecessor = predecessor;
	}
 
	public double getDistance() {
		return distance;
	}
 
	public void setDistance(double distance) {
		this.distance = distance;
	}
 
	@Override
	public String toString() {
		return this.planetNode;
	}
 
	@Override
	public int compareTo(PlanetVertex otherVertex) {
		return Double.compare(this.distance, otherVertex.getDistance());
	}

	public String getPlanetNode() {
		return planetNode;
	}

	public void setPlanetNode(String planetNode) {
		this.planetNode = planetNode;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
		
	}
}