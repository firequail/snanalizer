package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public class PuntosDeVistaRepositoryImpl extends
		BaseRepositoryImpl<PuntoDeVista> implements PuntosDeVistaRepository {

	public List<PuntoDeVista> getPuntosDeVista(Red red) {
		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("red", red));

		return find(criteria);
	}
}
