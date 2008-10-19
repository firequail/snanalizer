package snanalizer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Grafo {

	private List<Nodo> nodos = new LinkedList<Nodo>();

	public boolean contains(Nodo nodo) {
		return nodos.contains(nodo);
	}

	public void add(Nodo nodo) {
		nodos.add(nodo);
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	private Set<Relacion> getRelaciones(Filtro filtro) {
		Set<Relacion> conjuntoRelaciones = new HashSet<Relacion>();
		for (Nodo nodo : nodos) {
			nodo.addRelacionesTo(conjuntoRelaciones, filtro);
		}
		return conjuntoRelaciones;
	}
	
	private List<Relacion> getEdges(Filtro filtro) {
		HashMap<Nodo, HashMap<Nodo, Relacion>> edgesMap = new HashMap<Nodo, HashMap<Nodo, Relacion>>();
		
		for (Relacion edge : getRelaciones(filtro)) {
			HashMap<Nodo, Relacion> edgesDestino = edgesMap.get(edge.getDestino());
			if (edgesDestino != null) {
				Relacion edgeHermano = edgesDestino.get(edge.getOrigen());
				if ( edgeHermano != null ) {
					edgeHermano.setToIntensity(edge.getIntensidad());
					continue;
				} else {
					agregarEdge(edgesMap, edge);
				}
			} else {
				agregarEdge(edgesMap, edge);
			}
		}
		
		ArrayList<Relacion> edges = new ArrayList<Relacion>();
		
		for (HashMap<Nodo, Relacion> edgesDestino : edgesMap.values()) {
			for (Relacion relacion : edgesDestino.values()) {
				edges.add(relacion);
			}
		}
		
		return edges;
	}

	private void agregarEdge(HashMap<Nodo, HashMap<Nodo, Relacion>> edgesMap,
			Relacion edge) {
		
		HashMap<Nodo, Relacion> edgesOrigen = edgesMap.get(edge.getOrigen());
		if (edgesOrigen != null) {
			edgesOrigen.put(edge.getDestino(), edge);
		} else {
			HashMap<Nodo, Relacion> nuevoEdgesOrigen = new HashMap<Nodo, Relacion>();
			edgesMap.put(edge.getOrigen(), nuevoEdgesOrigen);
			nuevoEdgesOrigen.put(edge.getDestino(), edge);
		}
	}

	public String toXml(Filtro filtro) {
		StringBuilder builder = new StringBuilder("<Graph>\n");

		for (Nodo nodo : getNodos()) {
			builder.append(nodo.toXml());
		}

		for (Relacion relacion : getEdges(filtro)) {
			builder.append(relacion.toXml());
		}

		builder.append("</Graph>\n");

		return builder.toString();
	}
}
