package snanalizer.data;

import java.util.List;

import snanalizer.domain.DomainEntity;

public interface BaseRepository<E extends DomainEntity> {

	public List<E> getAll();

	public E getById(Long id);

	public void add(E newEntity);

	public void remove(Long id);

}