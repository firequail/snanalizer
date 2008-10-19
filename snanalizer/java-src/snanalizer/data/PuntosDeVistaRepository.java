package snanalizer.data;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Pregunta;

public interface PuntosDeVistaRepository extends BaseRepository<PuntoDeVista> {
	
	public PuntoDeVista getByPregunta(Pregunta preg);

}