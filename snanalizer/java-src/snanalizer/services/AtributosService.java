package snanalizer.services;

import java.util.List;

import snanalizer.domain.Atributo;

public interface AtributosService {

	public List<Atributo> getAll();
	
	public void modificar(Integer id, String nombre, String descripcion, Boolean estado);
	
	public void crear(String nombre, String descripcion, Boolean estado);
	
	public void crear(String nombre, String descripcion, Boolean estado,int datoMaestroId);

}
