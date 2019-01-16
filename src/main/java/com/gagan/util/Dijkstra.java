package com.gagan.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.hibernate.Session;

import com.gagan.model.Edge;
import com.gagan.model.PlanetVertex;

public class Dijkstra {
	
	public static void computePaths(PlanetVertex source) {
		source.setDistance(0.0);
		PriorityQueue<PlanetVertex> vertexQueue = new PriorityQueue<PlanetVertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			PlanetVertex u = vertexQueue.poll();

			for (Edge e : u.getAdjacencies()) {
				PlanetVertex v = e.getNextVertex();
				double weight = e.getWeight();
				double distanceThroughU = u.getDistance() + weight;
				if (distanceThroughU < v.getDistance()) {
					vertexQueue.remove(v);
					v.setDistance(distanceThroughU);
					v.setPredecessor(u);
					vertexQueue.add(v);
				}
			}
		}

		System.out.println(source.getDistance());
	}

	public static List<PlanetVertex> getShortestPathTo(PlanetVertex target) {
		List<PlanetVertex> path = new ArrayList<PlanetVertex>();
		for (PlanetVertex vertex = target; vertex != null; vertex = vertex.getPredecessor())
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {

		String startVertex = "A";
		String targetVertex = "G";
		Session session = HibernateUtil.getSessionFactory().openSession();
		PlanetVertex startPlanetVertex = session.get(PlanetVertex.class, startVertex);
		PlanetVertex targetPlanetVertex = session.get(PlanetVertex.class, targetVertex);
		try {
			System.out.println(findShortestPath(startPlanetVertex, targetPlanetVertex));
		} finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

	public static String findShortestPath(PlanetVertex startPlanetVertex, PlanetVertex targetPlanetVertex) {

		if (startPlanetVertex != null && targetPlanetVertex != null) {
			computePaths(startPlanetVertex);
			System.out.println("Distance to " + targetPlanetVertex + ": " + targetPlanetVertex.getDistance());
			List<PlanetVertex> path = getShortestPathTo(targetPlanetVertex);
			String result = "Shortest path between " + startPlanetVertex.getPlanetNode() + " to "
					+ targetPlanetVertex.getPlanetNode() + " is " + path + " and distance covered is "
					+ targetPlanetVertex.getDistance();

			return result;
		} else {
			return "Provided nodes are not present in DB";

		}

	}

}