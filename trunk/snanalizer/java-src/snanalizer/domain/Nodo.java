package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import snanalizer.util.XmlTagBuilder;

@Entity
public class Nodo extends DomainEntity {

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
		for (Relacion r : this.getRelaciones())
			if (r.getOrigen().getRecurso().equals(this.getRecurso()))
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
	public Grafo getGrafo(Filtro filtro) {
		Grafo grafo = new Grafo();
		recorrerGrafo(grafo, filtro);
		return grafo;
	}

	private void recorrerGrafo(Grafo grafo, Filtro filtro) {
		if (!grafo.contains(this)) {
			grafo.add(this);
			for (Relacion relacion : filtro.filtrarRelaciones(getRelaciones())) {
				relacion.getOrigen().recorrerGrafo(grafo, filtro);
				relacion.getDestino().recorrerGrafo(grafo, filtro);
			}
		}
	}

	public String toXml() {
		XmlTagBuilder builder = new XmlTagBuilder("Node");

		builder.addAttribute("id", getId());
		builder.addAttribute("name", getRecurso().getNombreYApellido());

		return "  " + builder.toString() + "\n";
	}

	public void addRelacionesTo(Set<Relacion> conjuntoRelaciones, Filtro filtro) {
		for (Relacion relacion : filtro.filtrarRelaciones(getRelaciones())) {
			conjuntoRelaciones.add(relacion);
		}
	}
}
