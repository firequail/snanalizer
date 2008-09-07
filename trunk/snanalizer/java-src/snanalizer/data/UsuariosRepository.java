package snanalizer.data;

import snanalizer.domain.Usuario;

public interface UsuariosRepository extends BaseRepository<Usuario> {

	public Usuario getUsuario(String username, String password);

}