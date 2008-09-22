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
}
