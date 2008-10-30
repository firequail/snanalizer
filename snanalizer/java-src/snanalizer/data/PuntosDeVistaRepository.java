package snanalizer.data;

import java.util.List;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Pregunta;
import snanalizer.domain.Red;

public interface PuntosDeVistaRepository extends BaseRepository<PuntoDeVista> {
	
	public PuntoDeVista getByPregunta(Pregunta preg);

	public List<PuntoDeVista> getByRed(Red red);

}