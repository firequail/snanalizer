package snanalizer.domain;



public class RespuestaValor extends DomainEntity {
	
	private String respuesta;
	private int valor;
	
	public RespuestaValor() {}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		return 17 * respuesta.hashCode() + 23 * valor;
	}

}
