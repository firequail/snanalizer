package snanalizer.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class EncuestaDePortal extends DomainEntity {

	private String nombre;

	private List<PreguntaDePortal> preguntas;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setPreguntas(List<PreguntaDePortal> preguntas) {
		this.preguntas = preguntas;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	public List<PreguntaDePortal> getPreguntas() {
		return preguntas;
	}
}
