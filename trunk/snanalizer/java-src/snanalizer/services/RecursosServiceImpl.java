package snanalizer.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.AtributosRepository;
import snanalizer.data.GruposRecursosRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.UsuariosRepository;
import snanalizer.domain.GrupoRecursos;
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
	@Resource 
	private GruposRecursosRepository grupos;
	
	
	public List<Recurso> getAll() {
		return recursos.getAll();
	}
	
	public List<Recurso> getAllExcept(int grupoId) {
		GrupoRecursos grupo = grupos.getById(grupoId);
		List<Recurso> listaCompleta = new ArrayList<Recurso>();
		listaCompleta.addAll(recursos.getAll());
		listaCompleta.removeAll(grupo.getRecursos());
		return listaCompleta;		
	}
	
	public List<Recurso> buscarRecursoByName(String nombre,String apellido) {
		return recursos.buscarRecursoByName(nombre, apellido);
	}
	
	public void crear(String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior, boolean estado) {
		
		Usuario usuario = new Usuario(email,password,"RECURSO");
		usuario.setApellido(apellido);
		usuario.setNombre(nombre);
		Recurso recurso = new Recurso(usuario);
		recurso.setArea(atributos.getAtributo(area));
		recurso.setPuesto(atributos.getAtributo(puesto));
		recurso.setSeniority(atributos.getAtributo(senior));
		recurso.setFechaNac(fecha);
		recurso.setEstado(estado);
		usuarios.add(usuario);
		recursos.add(recurso);
	}
	
	public void modificar(int id,String nombre, String apellido, String email, String password, Date fecha,int area, int puesto,int senior,boolean estado) {
		Recurso recurso = recursos.getById(id);
		Usuario usuario = recurso.getUsuario();
		usuario.setApellido(apellido);
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setPassword(password);
		recurso.setArea(atributos.getAtributo(area));
		recurso.setPuesto(atributos.getAtributo(puesto));
		recurso.setSeniority(atributos.getAtributo(senior));
		recurso.setFechaNac(fecha);
		recurso.setEstado(estado);
	}
	
	public Recurso getRecursoById(int recId) {
		return recursos.getById(recId);
	}

}
