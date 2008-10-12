package snanalizer.domain;

import javax.persistence.Entity;

@Entity
public class RespuestaDePortal extends DomainEntity {

	private String descripcion;

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
