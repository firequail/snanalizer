package snanalizer.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class DomainEntity {
	private Long id;

	public void setId(Long id) {
		if (id < 1) {
			this.id = null;
		} else {
			this.id = id;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * Indica si esta instancia puede ser considerada la misma que la pasada
	 * comparando por su identificador.
	 * 
	 * @return true si las dos instancias corresponden a la misma entidad de
	 *         negocio. Su clase es la misma, y su identificador tambien
	 */
	public boolean isSameEntityAs(DomainEntity otherEntity) {
		if (otherEntity == null) {
			return false;
		}
		if (!this.getEntityClass().equals(otherEntity.getEntityClass())) {
			return false;
		}
		return this.getId().equals(otherEntity.getId());
	}

	/**
	 * Devuelve la clase que representa la entidad de esta instancia. Debido a
	 * la utilizacion de proxies para implementar cierto comportamiento
	 * aspecteado el metodo getClass() devuelve la clase proxy, en vez de la
	 * clase proxiada. Este metod permite conocer la clase qeu representa la
	 * entidad antes de ser proxiada
	 * 
	 * @return La instancia de clase que representa la entidad de dominio de
	 *         esta instancia, mas alla de su clase real
	 */
	@Transient
	private Class<? extends DomainEntity> getEntityClass() {
		Class<? extends DomainEntity> clase = this.getClass();
		return clase;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DomainEntity)) {
			return false;
		}
		return isSameEntityAs((DomainEntity) obj);
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
}
