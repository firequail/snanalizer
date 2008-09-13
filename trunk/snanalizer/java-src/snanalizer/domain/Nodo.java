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

	public void setRelaciones(List<Relacion> relaciones) {
		this.relaciones = relaciones;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Relacion> getRelaciones() {
		return relaciones;
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
		// TODO: usar StringBuilder
		return "  <Node id=\"" + getId() + "\" name=\""
				+ getRecurso().getNombre() + " " + getRecurso().getApellido()
				+ "\"/>\n";
	}
	
	public void addRelacionesTo(Set<Relacion> conjuntoRelaciones) {
		for (Relacion relacion : getRelaciones()) {
			conjuntoRelaciones.add(relacion);
		}
	}
}
