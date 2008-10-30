package snanalizer.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Pregunta;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public class PuntosDeVistaRepositoryImpl extends
		BaseRepositoryImpl<PuntoDeVista> implements PuntosDeVistaRepository {
	
	public PuntoDeVista getByPregunta(Pregunta preg) {
		
		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("pregunta", preg));

		return findUnique(criteria);
	}
	
	public List<PuntoDeVista> getByRed(Red red) {
		ArrayList<PuntoDeVista> puntosDeVista = new ArrayList<PuntoDeVista>(red.getPuntosDeVista().size());
		puntosDeVista.addAll(red.getPuntosDeVista());
		return puntosDeVista;
	}
}
