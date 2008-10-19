package snanalizer.data;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Pregunta;
import snanalizer.domain.PuntoDeVista;

public class PuntosDeVistaRepositoryImpl extends
		BaseRepositoryImpl<PuntoDeVista> implements PuntosDeVistaRepository {
	
	public PuntoDeVista getByPregunta(Pregunta preg) {
		
		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("pregunta", preg));

		return findUnique(criteria);
		 
	}
}
