package br.com.machado.pedro.ivo.resources.exception.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.machado.pedro.ivo.client.ErrorResult;

public abstract class GenericExceptionHandler {

	@Context
	private HttpHeaders					headers;

	public Response handleException(int code, String message, Exception e) {
			return Response.status(code).entity(new ErrorResult(message.toString())).type(this.getMediaType()).build();
	}

	public MediaType getMediaType() {
		if (headers.getMediaType() != null && (headers.getMediaType().toString().contains("json") || headers.getMediaType().toString().contains("xml"))) { return headers.getMediaType(); }
		return MediaType.APPLICATION_JSON_TYPE;
	}

}
