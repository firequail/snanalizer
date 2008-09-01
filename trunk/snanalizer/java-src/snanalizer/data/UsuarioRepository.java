package snanalizer.data;

import snanalizer.domain.Usuario;

public interface UsuarioRepository extends BaseRepository<Usuario> {

	public Usuario getUsuario(String username, String password);

}