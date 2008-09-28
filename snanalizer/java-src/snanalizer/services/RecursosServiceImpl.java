package snanalizer.services;

import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.RecursosRepository;
import snanalizer.data.UsuariosRepository;
import snanalizer.data.AtributosRepository;
import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;



@Transactional
public class RecursosServiceImpl implements RecursosService {

	@Resource
	private RecursosRepository recursos;
	@Resource
	private UsuariosRepository usuarios;
	@Resource 
	private AtributosRepository atributos;
	
	
	public List<Recurso> getAll() {
		return recursos.getAll();
	}
	
	public void crear(String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior) {
		
		Usuario usuario = new Usuario(email,password,"RECURSO");
		usuario.setApellido(apellido);
		usuario.setNombre(nombre);
		Recurso recurso = new Recurso(usuario);
		Atributo objArea = new Atributo();
		Atributo objPuesto = new Atributo();
		Atributo objSeniority = new Atributo();
		objArea = atributos.getAtributo(area);
		objPuesto = atributos.getAtributo(puesto);
		objSeniority = atributos.getAtributo(senior);
		recurso.setArea(objArea);
		recurso.setPuesto(objPuesto);
		recurso.setSeniority(objSeniority);
		recurso.setFechaNac(fecha);
		usuarios.add(usuario);
		recursos.add(recurso);
	}
	

	
}
