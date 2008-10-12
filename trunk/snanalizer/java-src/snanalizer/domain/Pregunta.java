package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Pregunta extends DomainEntity {

	private String descripcion;

	private int maximaIntensidad;

	private Encuesta encuesta;

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

	@ManyToOne
	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
}
