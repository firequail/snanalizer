package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.Recurso;
import snanalizer.domain.RespuestaDePortal;
import snanalizer.domain.RespuestaDeRecurso;
import snanalizer.data.RespuestasDeRecursosRepository;

public class RespuestasDeRecursosRepositoryImpl extends BaseRepositoryImpl<RespuestaDeRecurso> implements RespuestasDeRecursosRepository  {
	
	public List<RespuestaDeRecurso> getRespuestasDeRecurso(Recurso rec) {

		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("recurso", rec));

		return find(criteria); 
		
	}
	
	public List<RespuestaDeRecurso> getRespuestasDeEncuesta(EncuestaDePortal enc) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("encuesta", enc));

		return find(criteria);
	}
	
	public List<RespuestaDeRecurso> getRespuestas(RespuestaDePortal rta) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("respuesta", rta));

		return find(criteria);
	}

}
