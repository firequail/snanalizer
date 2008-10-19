package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;

public class NodosRepositoryImpl extends BaseRepositoryImpl<Nodo>
		implements NodosRepository {

	public List<Nodo> getNodos(PuntoDeVista puntoDeVista) {
		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("puntoDeVista", puntoDeVista));

		return find(criteria);
	}
	

	

}
