package snanalizer.domain;

import javax.persistence.Entity;

@Entity
public class Pregunta extends DomainEntity {

	private String descripcion;
	
	private int maximaIntensidad;

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setMaximaIntensidad(int maximaIntensidad) {
		this.maximaIntensidad = maximaIntensidad;
	}

	public int getMaximaIntensidad() {
		return maximaIntensidad;
	}
}
