package snanalizer.services;

import java.util.Date;
import java.util.List;

import snanalizer.domain.Recurso;

public interface RecursosService {
	
	public List<Recurso> getAll();
	
	public List<Recurso> getAllExcept(int grupoId);
	
	public List<Recurso> buscarRecursoByName(String nombre, String apellido, boolean estado);
	
	public void crear(String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior,boolean estado);
	
	public void modificar(int id,String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior,boolean estado);
	
	public Recurso getRecursoById(int recId);
	
	public Recurso getRecursoByUsuario(int usuarioId);
	
	public void modificarDatosPersonales(int idRec,int idEstadoCivil,int idProvincia,String localidad);
	
	public void modificarOtrosDatos(int idRec, String titulo, int idEstab, int anioIng, int anioEg, String exp);
	
	public void modificarIdiomas(int idRec,int idId1, int idNi1,  int idId2, int idNi2, int idId3, int idNi3);
	
	public void modificarHobbies(int idRec,int idH1, int idH2,  int idH3, int idH4, int idH5, int idH6);
}
