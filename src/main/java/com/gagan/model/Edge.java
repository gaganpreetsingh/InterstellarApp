package com.gagan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="edge")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="routeId")
public class Edge {
	
	@Id
	@Column(name = "route_id")
	Integer routeId;
	
	@Column(name = "weight", nullable = false, length = 100)
	private double weight;
	
	@ManyToOne
	@JoinColumn(name="next_vertex")
	//@JsonIgnore
	private PlanetVertex nextVertex;
	
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public PlanetVertex getNextVertex() {
		return nextVertex;
	}
	public void setNextVertex(PlanetVertex nextVertex) {
		this.nextVertex = nextVertex;
	}

	@ManyToOne
	@JoinColumn(name="parent_vertex")
	@JsonIgnore
	private PlanetVertex parentVertex;
	
	public Edge(){
		
	}
	public Edge(int routeId, PlanetVertex nextVertex, PlanetVertex parentVertex, double weight) {
		this.routeId=routeId;
		this.weight = weight;
		this.nextVertex = nextVertex;
		this.parentVertex = parentVertex;
	}
 
	public double getWeight() {
		return weight;
	}
 
	public void setWeight(double weight) {
		this.weight = weight;
	}
 
	public PlanetVertex getParentVertex() {
		return parentVertex;
	}
 
	public void setParentVertex(PlanetVertex targetVertex) {
		this.parentVertex = targetVertex;
	}
	
	public String toString(){
		return nextVertex + " : Distance "+ weight;
	}
}
