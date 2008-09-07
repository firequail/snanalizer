package snanalizer.services;

import java.util.List;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public interface RedesService {

	public String getGrafo(int puntoDeVistaId);

	public List<PuntoDeVista> getPuntosDeVista(int redId);
	
	public List<Red> getRedes();
}