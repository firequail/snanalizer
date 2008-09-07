package snanalizer.services;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.UsuariosRepository;
import snanalizer.domain.Usuario;

@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource
	private UsuariosRepository usuarios;

	public void setUsuarios(UsuariosRepository usuarios) {
		this.usuarios = usuarios;
	}

	public UsuariosRepository getUsuarios() {
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
