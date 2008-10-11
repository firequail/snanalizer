package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Red extends DomainEntity {

	private String nombre;
	
	private String descripcion;

	private List<PuntoDeVista> puntosDeVista = new LinkedList<PuntoDeVista>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setPuntosDeVista(List<PuntoDeVista> puntosDeVista) {
		this.puntosDeVista = puntosDeVista;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<PuntoDeVista> getPuntosDeVista() {
		return puntosDeVista;
	}
}
