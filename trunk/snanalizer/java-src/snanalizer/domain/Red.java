package snanalizer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Red extends DomainEntity {

	private String descripcion;
	
	private List<PuntoDeVista> puntosDeVista;

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
}
