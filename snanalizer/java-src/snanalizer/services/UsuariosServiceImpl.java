package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.UsuarioRepository;
import snanalizer.domain.Usuario;

@Transactional
public class UsuariosServiceImpl implements UsuariosService {

	@Resource
	private UsuarioRepository usuarios;

	public void setUsuarios(UsuarioRepository usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioRepository getUsuarios() {
		return usuarios;
	}

	public List<Usuario> getAll() {
		return usuarios.getAll();
	}

	public void crear(String email, String password, String rol) {
		Usuario usuario = new Usuario(email, password, rol);
		usuarios.add(usuario);
	}

	public void modificar(Long id, String email, String password, String rol) {
		Usuario usuario = usuarios.getById(id);
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setRol(rol);
	}
}
