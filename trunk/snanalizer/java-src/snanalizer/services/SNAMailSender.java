package snanalizer.services;

import java.util.List;

import snanalizer.domain.Recurso;

public interface SNAMailSender {

	public void enviarEncuesta(List<Recurso> recursos);

}