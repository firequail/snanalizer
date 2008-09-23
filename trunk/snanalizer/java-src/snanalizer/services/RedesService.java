package snanalizer.services;

import java.util.List;

import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Filtro;
import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public interface RedesService {

	public List<PuntoDeVista> getPuntosDeVista(int redId);
	
	public List<Red> getRedes();
	
	public Nodo getNodo(int id);

	public String getGrafo(Integer idPtoVista, Integer idDatoMaestro, Filtro filtro);

	public List<DatoMaestro> getDatosMaestros();
}