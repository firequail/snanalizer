package snanalizer.data;

import java.util.List;

import snanalizer.domain.Usuario;

public interface UsuariosRepository extends BaseRepository<Usuario> {

	public Usuario getUsuario(String username, String password);

	public void removeAllRecursos();

	public List<Usuario> getNoRecursos();
	
	public List<Usuario> getUsuarioByName(String name, String apellido);

	public Usuario getByEmail(String email);
}