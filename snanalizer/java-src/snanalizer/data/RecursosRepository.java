package snanalizer.data;

import java.util.List;

import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;

public interface RecursosRepository extends BaseRepository<Recurso> {
	
	public List<Recurso> buscarRecursoByName(List<Usuario> user);

	public List<Recurso> buscarRecursoByName(String nombre, String apellido, boolean estado);

	public Recurso getByUsuario(Usuario usuario);

	public List<Recurso> getAllActivos();
}