package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import java.util.Date;
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
}
