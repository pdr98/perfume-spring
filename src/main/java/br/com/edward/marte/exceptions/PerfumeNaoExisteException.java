package br.com.edward.marte.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PerfumeNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PerfumeNaoExisteException(final Long id) {
		super("Perfume id " + id + " não existe.");
	}
}
