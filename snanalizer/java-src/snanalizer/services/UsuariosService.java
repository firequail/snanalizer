package snanalizer.services;

import java.util.List;

import snanalizer.domain.Usuario;

public interface UsuariosService {

	public List<Usuario> getAll();
	
	public void modificar(Integer id, String email, String password, String rol);
	
	public void crear(String email, String password, String rol);
	
	public void eliminar(Integer id);

}