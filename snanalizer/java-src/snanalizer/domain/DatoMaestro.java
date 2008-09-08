package snanalizer.domain;

import javax.persistence.Entity;

@Entity
public class DatoMaestro extends DomainEntity {
	private String descripcion;
	
	public DatoMaestro() {}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
