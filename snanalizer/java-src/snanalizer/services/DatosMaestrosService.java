package snanalizer.services;

import java.util.List;

import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;

public interface DatosMaestrosService {
	
	public List<DatoMaestro> getAll();

	public List<Atributo> getAtributos(int datoMaestroId);
}
