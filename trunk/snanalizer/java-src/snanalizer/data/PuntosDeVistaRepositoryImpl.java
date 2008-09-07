package snanalizer.data;

import java.util.List;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public class PuntosDeVistaRepositoryImpl extends
		BaseRepositoryImpl<PuntoDeVista> implements PuntosDeVistaRepository {

	/* (non-Javadoc)
	 * @see snanalizer.data.PuntoDeVistaRepository#getPuntosDeVista(snanalizer.domain.Red)
	 */
	public List<PuntoDeVista> getPuntosDeVista(Red red) {
		return getAll();
	}
}
