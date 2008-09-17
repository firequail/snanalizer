package snanalizer.services;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.domain.Nodo;

@Transactional
public interface NodosService {

	public Nodo getById(int id);
}
