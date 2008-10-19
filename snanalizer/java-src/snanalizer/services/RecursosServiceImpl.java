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
	
	public void modificarDatosPersonales(int idRec,int idEstadoCivil,int idProvincia,String localidad) {
		Recurso rec = recursos.getById(idRec);
		rec.setEstadoCivil(atributos.getById(idEstadoCivil));
		rec.setProvincia(atributos.getById(idProvincia));
		rec.setLocalidad(localidad);
	}
	
	public void modificarOtrosDatos(int idRec, String titulo, int idEstab, int anioIng, int anioEg, String exp) {
		Recurso rec = recursos.getById(idRec);
		rec.setTitulo(titulo);
		rec.setInstitucion(atributos.getById(idEstab));
		rec.setAnioIngreso(anioIng);
		rec.setAnioEgreso(anioEg);
		rec.setExperiencia(exp);
	}
	
	public void modificarIdiomas(int idRec, int idId1, int idNi1,  int idId2, int idNi2, int idId3, int idNi3) {
		Recurso rec = recursos.getById(idRec);
		rec.setIdioma1(atributos.getById(idId1));
		rec.setIdioma2(atributos.getById(idId2));
		rec.setIdioma3(atributos.getById(idId3));
		rec.setNivelIdioma1(atributos.getById(idNi1));
		rec.setNivelIdioma2(atributos.getById(idNi2));
		rec.setNivelIdioma3(atributos.getById(idNi3));
		
	}
	
	public void modificarHobbies(int idRec, int idH1, int idH2,  int idH3, int idH4, int idH5, int idH6) {
		Recurso rec = recursos.getById(idRec);
		rec.setHobbie1(atributos.getById(idH1));
		rec.setHobbie2(atributos.getById(idH2));
		rec.setHobbie3(atributos.getById(idH3));
		rec.setHobbie4(atributos.getById(idH4));
		rec.setHobbie5(atributos.getById(idH5));
		rec.setHobbie6(atributos.getById(idH6));
	}

}
