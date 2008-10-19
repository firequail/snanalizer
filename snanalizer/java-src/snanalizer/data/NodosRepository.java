package snanalizer.data;

import java.util.List;

import snanalizer.domain.Nodo;
import snanalizer.domain.Recurso;
import snanalizer.domain.PuntoDeVista;

public interface NodosRepository extends BaseRepository<Nodo> {

	public List<Nodo> getNodos( PuntoDeVista puntoDeVista );
	
	public Nodo getByRec(Recurso rec);
}