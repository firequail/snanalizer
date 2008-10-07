package snanalizer.services;

import java.util.List;

import snanalizer.domain.Encuesta;

public interface EncuestasService {

	public void crear(Encuesta encuesta);

	public List<Encuesta> getEncuestas();
}
