package br.com.machado.pedro.ivo.beans.exceptions;

public class ValidationException extends RuntimeException {

	private static final long	serialVersionUID	= -6273652995439057479L;

	public ValidationException() {
		super();
	}

	public ValidationException(final String message) {
		super(message);
	}

	public ValidationException(final String message, final Throwable throwable) {
		super(message, throwable);
	}
}
