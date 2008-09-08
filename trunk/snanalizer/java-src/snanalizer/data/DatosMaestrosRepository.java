package snanalizer.data;

import snanalizer.domain.DatoMaestro;

public interface DatosMaestrosRepository extends BaseRepository<DatoMaestro> {

	public DatoMaestro getDatoMaestro();
	
}
