package snanalizer.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Recurso extends DomainEntity {

	private Usuario usuario;
	private Date fechaNac;
	private Atributo area;
	private Atributo puesto;
	private Atributo seniority;
	private Atributo estadoCivil;
	private String localidad;
	private Atributo provincia;
	private String titulo;
	private Atributo institucion;
	private int anioIngreso;
	private int anioEgreso;
	private Atributo idioma1;
	private Atributo idioma2;
	private Atributo idioma3;
	private Atributo nivelIdioma1;
	private Atributo nivelIdioma2;
	private Atributo nivelIdioma3;
	private Atributo hobbie1;
	private Atributo hobbie2;
	private Atributo hobbie3;
	private Atributo hobbie4;
	private Atributo hobbie5;
	private Atributo hobbie6;
	private String experiencia;
	private Boolean estado;
	private String picture;

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
		// TODO: devolver el atributo correspondiente al dato maestro
		if ("area".equalsIgnoreCase(datoMaestro.getDescripcion())) {
			return area;
		}
		if ("puesto".equalsIgnoreCase(datoMaestro.getDescripcion())) {
			return puesto;
		}
		if ("seniority".equalsIgnoreCase(datoMaestro.getDescripcion())) {
			return seniority;
		}
		return null;
	}

	public void setAtributo(Atributo atributo) {
		if ("area".equalsIgnoreCase(atributo.getDatoMaestro().getDescripcion())) {
			this.area = atributo;
		}
		if ("puesto".equalsIgnoreCase(atributo.getDatoMaestro()
				.getDescripcion())) {
			this.puesto = atributo;
		}
		if ("seniority".equalsIgnoreCase(atributo.getDatoMaestro()
				.getDescripcion())) {
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setIdioma1(Atributo idioma) {
		this.idioma1 = idioma;
	}

	@ManyToOne
	public Atributo getIdioma1() {
		return idioma1;
	}

	public void setIdioma2(Atributo idioma) {
		this.idioma2 = idioma;
	}

	@ManyToOne
	public Atributo getIdioma2() {
		return idioma2;
	}

	public void setIdioma3(Atributo idioma) {
		this.idioma3 = idioma;
	}

	@ManyToOne
	public Atributo getIdioma3() {
		return idioma3;
	}

	public void setNivelIdioma1(Atributo nivelIdioma) {
		this.nivelIdioma1 = nivelIdioma;
	}

	@ManyToOne
	public Atributo getNivelIdioma1() {
		return nivelIdioma1;
	}

	public void setNivelIdioma2(Atributo nivelIdioma) {
		this.nivelIdioma2 = nivelIdioma;
	}

	@ManyToOne
	public Atributo getNivelIdioma2() {
		return nivelIdioma2;
	}

	public void setNivelIdioma3(Atributo nivelIdioma) {
		this.nivelIdioma3 = nivelIdioma;
	}

	@ManyToOne
	public Atributo getNivelIdioma3() {
		return nivelIdioma3;
	}

	public void setHobbie1(Atributo hobbie) {
		this.hobbie1 = hobbie;
	}

	@ManyToOne
	public Atributo getHobbie1() {
		return hobbie1;
	}

	public void setHobbie2(Atributo hobbie) {
		this.hobbie2 = hobbie;
	}

	@ManyToOne
	public Atributo getHobbie2() {
		return hobbie2;
	}

	public void setHobbie3(Atributo hobbie) {
		this.hobbie3 = hobbie;
	}

	@ManyToOne
	public Atributo getHobbie3() {
		return hobbie3;
	}

	public void setHobbie4(Atributo hobbie) {
		this.hobbie4 = hobbie;
	}

	@ManyToOne
	public Atributo getHobbie4() {
		return hobbie4;
	}

	public void setHobbie5(Atributo hobbie) {
		this.hobbie5 = hobbie;
	}

	@ManyToOne
	public Atributo getHobbie5() {
		return hobbie5;
	}

	public void setHobbie6(Atributo hobbie) {
		this.hobbie6 = hobbie;
	}

	@ManyToOne
	public Atributo getHobbie6() {
		return hobbie6;
	}

	public void setProvincia(Atributo provincia) {
		this.provincia = provincia;
	}

	@ManyToOne
	public Atributo getProvincia() {
		return provincia;
	}

	public void setInstitucion(Atributo institucion) {
		this.institucion = institucion;
	}

	@ManyToOne
	public Atributo getInstitucion() {
		return institucion;
	}

	@ManyToOne
	public Atributo getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Atributo estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioEgreso(int anioEgreso) {
		this.anioEgreso = anioEgreso;
	}

	public int getAnioEgreso() {
		return anioEgreso;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getExperiencia() {
		return experiencia;
	}

}
