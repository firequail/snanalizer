package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class GrupoRecursos extends DomainEntity {
	private String descripcion;
	private List<Recurso> recursos = new LinkedList<Recurso>();
	
	public GrupoRecursos() {}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Recurso> getRecursos() {
		return recursos;
	}
	
}
