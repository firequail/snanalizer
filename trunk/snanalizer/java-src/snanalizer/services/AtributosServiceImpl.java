package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.AtributosRepository;
import snanalizer.domain.Atributo;

@Transactional
public class AtributosServiceImpl implements AtributosService {

	@Resource
	private AtributosRepository atributos;

	public void setAtributos(AtributosRepository atributos) {
		this.atributos = atributos;
	}

	public AtributosRepository getAtributos() {
		return atributos;
	}

	public List<Atributo> getAll() {
		return atributos.getAll();
	}

	public void crear(String nombre, String descripcion, Boolean estado) {
		Atributo atributo = new Atributo(nombre, descripcion, estado);
		atributos.add(atributo);
	}

	public void modificar(Integer id, String nombre, String descripcion, Boolean estado) {
		Atributo atributo = atributos.getById(id);
		atributo.setNombre(nombre);
		atributo.setDescripcion(descripcion);
		atributo.setEstado(estado);
	}
}
