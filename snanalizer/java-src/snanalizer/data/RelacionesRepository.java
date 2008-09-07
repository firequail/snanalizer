package snanalizer.data;

import java.util.List;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Relacion;

public interface RelacionesRepository extends BaseRepository<Relacion> {

	public List<Relacion> getRelaciones( PuntoDeVista puntoDeVista );
}