package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import snanalizer.util.XmlTagBuilder;
import snanalizer.domain.Recurso;

@Entity
public class Nodo extends DomainEntity {

	/**
	 * Relaciones salientes
	 */
	private List<Relacion> relaciones = new LinkedList<Relacion>();

	private Recurso recurso;

	public Nodo() {

	}

	public Nodo(Recurso recurso) {
		this.recurso = recurso;
	}

	public Relacion linkTo(Nodo nodoDestino, int intensidad) {
		Relacion relacion = new Relacion(this, nodoDestino, intensidad);
		this.addRelacion(relacion);
		nodoDestino.addRelacion(relacion);
		return relacion;
	}

	public void setRelaciones(List<Relacion> relaciones) {
		this.relaciones = relaciones;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Relacion> getRelaciones() {
		return relaciones;
	}
	
	public boolean tieneRelacionesSalientes() {
		for(Relacion r : this.getRelaciones())
			if(r.getOrigen().getRecurso().equals(this.getRecurso()))
				return true;
		return false;
	}

	public void addRelacion(Relacion relacion) {
		getRelaciones().add(relacion);
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	@ManyToOne
	public Recurso getRecurso() {
		return recurso;
	}

	@Transient
	public Grafo getGrafo() {
		Grafo grafo = new Grafo();
		recorrerGrafo(grafo);
		return grafo;
	}

	private void recorrerGrafo(Grafo grafo) {
		if (!grafo.contains(this)) {
			grafo.add(this);
			for (Relacion relacion : getRelaciones()) {
				relacion.getOrigen().recorrerGrafo(grafo);
				relacion.getDestino().recorrerGrafo(grafo);
			}
		}
	}

	public String toXml() {
		XmlTagBuilder builder = new XmlTagBuilder("Node");

		builder.addAttribute("id", getId());
		builder.addAttribute("name", getRecurso().getNombreYApellido());

		return "  " + builder.toString() + "\n";
	}

	public void addRelacionesTo(Set<Relacion> conjuntoRelaciones) {
		for (Relacion relacion : getRelaciones()) {
			conjuntoRelaciones.add(relacion);
		}
	}
}
