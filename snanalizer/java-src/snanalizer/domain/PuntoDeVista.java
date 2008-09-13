package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class PuntoDeVista extends DomainEntity {

	private String descripcion;

	private List<Nodo> nodos = new LinkedList<Nodo>();

	public PuntoDeVista() {

	}

	public PuntoDeVista(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Nodo> getNodos() {
		return nodos;
	}

	@Transient
	public List<Grafo> getSubgrafos() {
		List<Nodo> nodosRestantes = new LinkedList<Nodo>(getNodos());
		List<Grafo> subgrafos = new LinkedList<Grafo>();
		
		while (!nodosRestantes.isEmpty()) {
			Nodo root = nodosRestantes.get(0);
			Grafo subgrafo = root.getGrafo();
			subgrafos.add(subgrafo);
			nodosRestantes.removeAll(subgrafo.getNodos());
		}
		
		return subgrafos;
	}
	
	public String toXml() {
		StringBuilder builder = new StringBuilder();
		
		for (Grafo subgrafo : getSubgrafos()) {
			builder.append(subgrafo.toXml());
		}
		
		return builder.toString();
	}
}
