package br.com.machado.pedro.ivo.resources.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import br.com.machado.pedro.ivo.beans.exceptions.ValidationException;

@Provider
public class ValidationExceptionHandler extends GenericExceptionHandler implements ExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(ValidationException e) {
		return super.handleException(412, e.getMessage(), e);
	}

}
