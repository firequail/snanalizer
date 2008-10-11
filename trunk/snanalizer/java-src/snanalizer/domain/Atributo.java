package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Atributo extends DomainEntity {
	private String nombre;
	private String descripcion;
	private Boolean estado;
	private DatoMaestro datoMaestro;

	public Atributo() {

	}

	public Atributo(String nombre, String descripcion, Boolean estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Atributo(String nombre, String descripcion, Boolean estado,
			DatoMaestro dm) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.datoMaestro = dm;
		dm.getAtributos().add(this);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setDatoMaestro(DatoMaestro datoMaestro) {
		this.datoMaestro = datoMaestro;
	}

	@ManyToOne
	public DatoMaestro getDatoMaestro() {
		return datoMaestro;
	}

}