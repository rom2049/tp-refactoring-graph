package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
	
	private List<Edge> edges = new ArrayList<Edge>();
	
	public Path(List<Edge> edges) {
		this.edges = edges;
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public double getLength() {
		double length = 0;
		for(Edge edge: this.edges) {
			length += edge.getCost();
		}
		return length;
	}

}
