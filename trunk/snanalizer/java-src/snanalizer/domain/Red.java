package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Red extends DomainEntity {

	private String descripcion;

	private List<PuntoDeVista> puntosDeVista = new LinkedList<PuntoDeVista>();

	private List<Recurso> recursos = new LinkedList<Recurso>();
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setPuntosDeVista(List<PuntoDeVista> puntosDeVista) {
		this.puntosDeVista = puntosDeVista;
	}

	@OneToMany
	public List<PuntoDeVista> getPuntosDeVista() {
		return puntosDeVista;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	@OneToMany
	public List<Recurso> getRecursos() {
		return recursos;
	}
}
