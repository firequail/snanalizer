package snanalizer.services;

import java.util.List;

import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public interface RedesService {

	public String getGrafo(int puntoDeVistaId);

	public List<PuntoDeVista> getPuntosDeVista(int redId);
	
	public List<Red> getRedes();
	
	public Nodo getNodo(int id);

	public String getGrafoAgrupado(Integer idPtoVista, Integer idDatoMaestro);
}