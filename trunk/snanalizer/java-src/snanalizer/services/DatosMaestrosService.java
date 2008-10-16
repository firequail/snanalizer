package snanalizer.services;

import java.util.List;

import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;

public interface DatosMaestrosService {
	
	public List<DatoMaestro> getAll();

	public List<Atributo> getAtributos(int datoMaestroId);
	
	public List<Atributo> getAtributosByDesc(String desc);
	
	public List<Atributo> getAreas();
	public List<Atributo> getPuestos();
	public List<Atributo> getSeniorities();
	public List<Atributo> getHobbies();
	public List<Atributo> getInstituciones();
	public List<Atributo> getNiveles();
	public List<Atributo> getIdiomas();
	public List<Atributo> getProvincias();
	
}
