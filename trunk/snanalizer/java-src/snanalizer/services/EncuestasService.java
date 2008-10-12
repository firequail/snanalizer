package snanalizer.services;

import java.util.List;

import snanalizer.domain.Encuesta;
import snanalizer.domain.EncuestaDePortal;

public interface EncuestasService {

	public void crear(Encuesta encuesta);

	public void crearEncuestaPortal(EncuestaDePortal encuestaDePortal);
	
	public List<Encuesta> getEncuestas();
	
	public List<EncuestaDePortal> getEncuestasPortal();
}
