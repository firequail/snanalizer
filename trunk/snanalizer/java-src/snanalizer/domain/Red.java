package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Red extends DomainEntity {

	private String descripcion;

	private List<PuntoDeVista> puntosDeVista = new LinkedList<PuntoDeVista>();

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setPuntosDeVista(List<PuntoDeVista> puntosDeVista) {
		this.puntosDeVista = puntosDeVista;
	}

	@OneToMany( fetch = FetchType.EAGER )
	public List<PuntoDeVista> getPuntosDeVista() {
		return puntosDeVista;
	}
}
