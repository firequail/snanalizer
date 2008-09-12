package snanalizer.data;

import java.util.List;
import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;

public interface AtributosRepository extends BaseRepository<Atributo> {

	public Atributo getAtributo();
	public abstract List<Atributo> getAtributos(DatoMaestro dm);

}