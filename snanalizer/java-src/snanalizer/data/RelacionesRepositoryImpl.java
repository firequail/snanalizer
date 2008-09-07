package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Relacion;

public class RelacionesRepositoryImpl extends BaseRepositoryImpl<Relacion>
		implements RelacionesRepository {

	public List<Relacion> getRelaciones(PuntoDeVista puntoDeVista) {
		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("puntoDeVista", puntoDeVista));

		return find(criteria);
	}
}
