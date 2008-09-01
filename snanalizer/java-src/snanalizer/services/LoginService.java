package snanalizer.services;

import snanalizer.domain.Usuario;

public interface LoginService {

	public Usuario login(String username, String password);

}