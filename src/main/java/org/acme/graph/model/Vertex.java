package org.acme.graph.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graphe
 * 
 * @author MBorne
 *
 */
public class Vertex {

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;

	private List<Edge> inEdges = new ArrayList<Edge>();

	private List<Edge> outEdges = new ArrayList<Edge>();

	Vertex() {

	}

	@JsonIgnore
	public List<Edge> getInEdges() {
		return this.inEdges;
	}

	@JsonIgnore
	public List<Edge> getOutEdges() {
		return this.outEdges;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}



	@Override
	public String toString() {
		return id;
	}

}
