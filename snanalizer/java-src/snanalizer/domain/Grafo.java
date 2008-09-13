package snanalizer.domain;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private Set<Nodo> nodos = new HashSet<Nodo>();

	public boolean contains(Nodo nodo) {
		return nodos.contains(nodo);
	}

	public void add(Nodo nodo) {
		nodos.add(nodo);
	}

	public Set<Nodo> getNodos() {
		return nodos;
	}

	public Set<Relacion> getRelaciones() {
		Set<Relacion> conjuntoRelaciones = new HashSet<Relacion>();
		for (Nodo nodo : nodos) {
			nodo.addRelacionesTo(conjuntoRelaciones);
		}
		return conjuntoRelaciones;
	}

	public String toXml() {
		StringBuilder builder = new StringBuilder("<Graph>\n");

		for (Nodo nodo : getNodos()) {
			builder.append(nodo.toXml());
		}

		for (Relacion relacion : getRelaciones()) {
			builder.append(relacion.toXml());
		}

		builder.append("</Graph>\n");

		return builder.toString();
	}
}
