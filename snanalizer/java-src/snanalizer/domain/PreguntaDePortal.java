package snanalizer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class PreguntaDePortal extends DomainEntity {

	private String descripcion;

	private List<RespuestaDePortal> respuestas;

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setRespuestas(List<RespuestaDePortal> respuestas) {
		this.respuestas = respuestas;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	public List<RespuestaDePortal> getRespuestas() {
		return respuestas;
	}
}
