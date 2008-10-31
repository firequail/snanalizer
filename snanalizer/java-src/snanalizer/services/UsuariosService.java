package snanalizer.services;

import java.util.List;

import snanalizer.domain.Usuario;

public interface UsuariosService {

	public List<Usuario> getAll();
	
	public List<Usuario> getNoRecursos();
	
	public void modificar(Integer id, String email, String password, String nombre, String apellido, String rol);
	
	public void crear(String email, String password, String nombre, String apellido, String rol);
	
	public void eliminar(Integer id);
	
	public Usuario getById(int id);

	public Usuario getByEmail(String email);
	
}