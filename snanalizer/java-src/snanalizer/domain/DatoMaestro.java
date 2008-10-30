package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class DatoMaestro extends DomainEntity {
	private String descripcion;
	private List<Atributo> atributos = new LinkedList<Atributo>();
	
	
	public DatoMaestro() {}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	public List<Atributo> getAtributos() {
		return atributos;
	}
	
}
