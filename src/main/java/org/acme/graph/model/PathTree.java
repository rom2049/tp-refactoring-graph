package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathTree {
	
	private Map<Vertex,PathNode> nodes = new HashMap<Vertex,PathNode>();
	
	public PathTree() {
		this.nodes = new HashMap<Vertex,PathNode>();
	}
	
	/**
	 * Prépare le graphe pour le calcul du plus court chemin
	 * 
	 * @param source
	 */
	public PathTree(Graph graph, Vertex origin) {
		for (Vertex vertex : graph.getVertices()) {
			PathNode pathNode = new PathNode();
			pathNode.setCost(origin == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pathNode.setReachingEdge(null);
			pathNode.setVisited(false);
			this.nodes.put(vertex, pathNode);
		}
	}
	
	
	public PathNode getNode(Vertex vertex) {
		return this.nodes.get(vertex);
	}
	
	
	/**
	 * Construit le chemin en remontant les relations incoming edge
	 * 
	 * @param target
	 * @return
	 */
	public List<Edge> getPath(Vertex destination) {
		List<Edge> result = new ArrayList<>();

		Edge current = getNode(destination).getReachingEdge();
		do {
			result.add(current);
			current = getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result);
		return result;
	}




}
