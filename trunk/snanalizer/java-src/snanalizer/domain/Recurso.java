package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Basic;
import javax.persistence.Lob;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.Column;


import java.util.Date;
//import java.sql.Date;
import snanalizer.domain.Atributo;

@Entity
public class Recurso extends DomainEntity {

	private Usuario usuario;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private Atributo area;
	private Atributo puesto;
	private Atributo seniority;
	private Boolean estado;
	
	@Basic(fetch=LAZY)
	@Lob @Column(name="PIC")
	private byte[] picture;
	

	public Recurso() {

	}

	public Recurso(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	@Transient
	public String getNombreYApellido() {
		return getNombre() + " " + getApellido();
	}


	@Transient
	public String getNombre() {
		return getUsuario().getNombre();
	}

	@Transient
	public String getApellido() {
		return getUsuario().getApellido();
	}


	public Object getAtributo(DatoMaestro datoMaestro) {
		//TODO: devolver el atributo correspondiente al dato maestro
		if ("area".equalsIgnoreCase(datoMaestro.getDescripcion())){
			return area;
		}
		if ("puesto".equalsIgnoreCase(datoMaestro.getDescripcion())){
			return puesto;
		}
		if ("seniority".equalsIgnoreCase(datoMaestro.getDescripcion())){
			return seniority;
		}
		return null;
	}
	
	public void setAtributo(Atributo atributo) {
		if ("area".equalsIgnoreCase(atributo.getDatoMaestro().getDescripcion())){
			this.area = atributo;
		}
		if ("puesto".equalsIgnoreCase(atributo.getDatoMaestro().getDescripcion())){
			this.puesto = atributo;
		}
		if ("seniority".equalsIgnoreCase(atributo.getDatoMaestro().getDescripcion())){
			this.seniority = atributo;
		}
	}

	public void setPuesto(Atributo puesto) {
		this.puesto = puesto;
	}

	@ManyToOne
	public Atributo getPuesto() {
		return puesto;
	}
	
	@ManyToOne
	public Atributo getArea() {
		return area;
	}
	
	public void setArea(Atributo area) {
		this.area = area;
	}
	
	@ManyToOne
	public Atributo getSeniority() {
		return seniority;
	}
	
	public void setSeniority(Atributo seniority) {
		this.seniority = seniority;
	}



	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
	
	
}
