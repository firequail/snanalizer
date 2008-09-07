package snanalizer.services;

import java.io.FileNotFoundException;
import java.util.List;

import snanalizer.domain.PuntoDeVista;

public interface RedesService {

	public String getGrafo(int puntoDeVistaId) throws FileNotFoundException;

	public List<PuntoDeVista> getPuntosDeVista(int redId);
}