package snanalizer.services;

import java.util.Date;
import java.util.List;

import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;

public interface RecursosService {
	
	public List<Recurso> getAll();
	
	public void crear(String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior,boolean estado);
	
	public void modificar(int id,String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior,boolean estado);

}
