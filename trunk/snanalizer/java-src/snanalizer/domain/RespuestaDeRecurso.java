package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import snanalizer.domain.Recurso;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.RespuestaDePortal;

@Entity
public class RespuestaDeRecurso extends DomainEntity {

	private Recurso recurso;
	private EncuestaDePortal encuesta;
	private RespuestaDePortal respuesta;
	
	public RespuestaDeRecurso() {}
	
	public RespuestaDeRecurso(Recurso rec, EncuestaDePortal enc, RespuestaDePortal res) {
		this.recurso = rec;
		this.encuesta = enc;
		this.respuesta = res;
	}
	
	
	@ManyToOne
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
	@ManyToOne
	public EncuestaDePortal getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(EncuestaDePortal encuesta) {
		this.encuesta = encuesta;
	}
	
	@ManyToOne
	public RespuestaDePortal getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaDePortal respuesta) {
		this.respuesta = respuesta;
	}
	
	
	


}
