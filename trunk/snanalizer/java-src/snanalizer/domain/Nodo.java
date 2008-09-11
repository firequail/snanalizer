package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Nodo extends DomainEntity {

	/**
	 * Relaciones salientes
	 */
	private List<Relacion> relaciones = new LinkedList<Relacion>();

	private Recurso recurso;

	private PuntoDeVista puntoDeVista;

	public Nodo() {

	}

	public Nodo(Recurso recurso, PuntoDeVista puntoDeVista) {
		this.recurso = recurso;
		this.puntoDeVista = puntoDeVista;
	}

	public void setRelaciones(List<Relacion> relaciones) {
		this.relaciones = relaciones;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Relacion> getRelaciones() {
		return relaciones;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	@ManyToOne
	public Recurso getRecurso() {
		return recurso;
	}

	public void setPuntoDeVista(PuntoDeVista puntoDeVista) {
		this.puntoDeVista = puntoDeVista;
	}

	@ManyToOne
	public PuntoDeVista getPuntoDeVista() {
		return puntoDeVista;
	}

	public String toXml() {
		// TODO: usar StringBuilder
		return "<Node id=\"" + getId() + "\" name=\""
				+ getRecurso().getNombre() + " " + getRecurso().getApellido()
				+ "\"/>";
	}
}
