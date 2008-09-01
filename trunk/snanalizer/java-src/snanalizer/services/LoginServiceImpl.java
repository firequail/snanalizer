package snanalizer.services;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.UsuarioRepository;
import snanalizer.domain.Usuario;

@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource
	private UsuarioRepository usuarios;

	public void setUsuarios(UsuarioRepository usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioRepository getUsuarios() {
		return usuarios;
	}

	public Usuario login(String email, String password) {

		Usuario usuario = getUsuarios().getUsuario(email, password);

		if (usuario == null) {
			throw new UsuarioInvalidoException(email);
		}

		return usuario;
	}
}
