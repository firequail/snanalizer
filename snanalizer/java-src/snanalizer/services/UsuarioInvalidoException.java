package snanalizer.services;

public class UsuarioInvalidoException extends RuntimeException {

	/** No cambiar. */
	private static final long serialVersionUID = -3070710630210170602L;

	private String email;

	public UsuarioInvalidoException(String email) {
		this.setEmail(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
