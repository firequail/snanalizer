package snanalizer.data;

import java.util.List;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public interface PuntosDeVistaRepository extends BaseRepository<PuntoDeVista> {

	public abstract List<PuntoDeVista> getPuntosDeVista(Red red);

}