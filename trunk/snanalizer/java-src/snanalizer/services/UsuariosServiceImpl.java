package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.UsuariosRepository;
import snanalizer.domain.Usuario;

@Transactional
public class UsuariosServiceImpl implements UsuariosService {

	@Resource
	private UsuariosRepository usuarios;

	public void setUsuarios(UsuariosRepository usuarios) {
		this.usuarios = usuarios;
	}

	public UsuariosRepository getUsuarios() {
		return usuarios;
	}

	public List<Usuario> getNoRecursos() {
		return usuarios.getNoRecursos();
	}
	
	public List<Usuario> getAll() {
		return usuarios.getAll();
	}

	public void crear(String email, String password, String rol) {
		Usuario usuario = new Usuario(email, password, rol);
		usuarios.add(usuario);
	}

	public void modificar(Integer id, String email, String password, String rol) {
		Usuario usuario = usuarios.getById(id);
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setRol(rol);
	}
	
	public void eliminar(Integer id) {
		usuarios.remove(id);
	}

	public Usuario getById(int id) {
		return usuarios.getById(id);
	}
}
