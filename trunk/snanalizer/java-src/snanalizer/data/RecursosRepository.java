package snanalizer.data;

import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;
import java.util.List;

public interface RecursosRepository extends BaseRepository<Recurso> {
	
	public List<Recurso> buscarRecursoByName(Usuario user);

}