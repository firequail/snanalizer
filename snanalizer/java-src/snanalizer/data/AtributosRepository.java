package snanalizer.data;

import snanalizer.domain.Atributo;

public interface AtributosRepository extends BaseRepository<Atributo> {

	public Atributo getAtributo(String nombre);

}