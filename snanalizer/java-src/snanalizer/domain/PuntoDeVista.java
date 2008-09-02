package snanalizer.domain;

import javax.persistence.Entity;

@Entity
public class PuntoDeVista extends DomainEntity {

	private String descripcion;

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
