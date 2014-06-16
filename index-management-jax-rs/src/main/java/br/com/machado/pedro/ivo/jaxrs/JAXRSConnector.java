package br.com.machado.pedro.ivo.jaxrs;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import br.com.machado.pedro.ivo.beans.exceptions.ValidationException;
import br.com.machado.pedro.ivo.client.ErrorResult;

public class JAXRSConnector<T> {

	private ResteasyClient		client	= new ResteasyClientBuilder().build();
	private ResteasyWebTarget	wt;
	private MediaType					type		= MediaType.APPLICATION_JSON_TYPE;
	private Builder						builder;

	/**
	 * Construtor Padrao da Classe. Os metodos devem ser mantidos nessa ordem. Primeiro configuramos o path e em seguida os headers. Headers sao configurados no
	 * Builder e path no WebResource. O metodo HTTP (put, get, delete ou post) deve ser chamado atraves do builder.
	 */
	protected JAXRSConnector(final String contextUrl, final List<String> pathParams) {
		this.wt = client.target(contextUrl);
		setPathParams(pathParams);
		this.builder = this.wt.request(type);
	}

	/**
	 * 
	 * @param pathParams
	 * @param queryParams
	 */
	protected JAXRSConnector(final String contextUrl, final List<String> pathParams, final MultivaluedMap<String, Object> queryParams) {
		this.wt = client.target(contextUrl);
		setPathParams(pathParams);
		setQueryParams(queryParams);
		this.builder = this.wt.request(type);
	}

	/**
	 * 
	 * @param pathParams
	 * @param headerParams
	 * @param url
	 */
	public JAXRSConnector(final String contextUrl, final List<String> pathParams, final Map<String, String> headerParams) {
		this(contextUrl, pathParams);
		setHeaderParams(headerParams);
	}

	/**
	 * 
	 * @param pathParams
	 * @param queryParams
	 * @param headerParams
	 * @param url
	 */
	public JAXRSConnector(final String contextUrl, final List<String> pathParams, final MultivaluedMap<String, Object> queryParams,
			final Map<String, String> headerParams) {
		this(contextUrl, pathParams, queryParams);
		setHeaderParams(headerParams);
	}

	public JAXRSConnector(String contextUrl, List<String> pathParams, MultivaluedMap<String, Object> queryParams, Map<String, String> headerParams, MediaType type) {
		this.type = type;
		this.wt = client.target(contextUrl);
		setPathParams(pathParams);
		setQueryParams(queryParams);
		this.builder = this.wt.request(type);
		setHeaderParams(headerParams);
	}

	private void exceptionFactory(Response response) throws ValidationException, Exception {
		ErrorResult result = response.readEntity(ErrorResult.class);
		switch (response.getStatus()) {
			case 412:
				throw new ValidationException(result.getError());
			default:
				throw new Exception(result.getError());
		}
	}

	private T responseHandler(Response response, final GenericType<T> generic) throws ValidationException, Exception {
		if (response.getStatus() != 200) {
			exceptionFactory(response);
		}
		if (response.getLength() <= 0) { return null; }
		return response.readEntity(generic);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T get(final GenericType<T> generic) throws ValidationException, Exception {
		return responseHandler(this.builder.get(), generic);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T delete(final GenericType<T> generic) throws ValidationException, Exception {
		return responseHandler(this.builder.delete(), generic);
	}

	/**
	 * 
	 * @param generic
	 * @param obj
	 * @return
	 */
	protected T put(final GenericType<T> generic, final Object obj) throws ValidationException, Exception {
		return responseHandler(this.builder.put(Entity.entity(obj, type)), generic);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T put(final GenericType<T> generic) throws ValidationException, Exception {

		return responseHandler(this.builder.put(null), generic);
	}

	/**
	 * 
	 * @param generic
	 * @param obj
	 * @return
	 */
	protected T post(final GenericType<T> generic, final Object obj) throws ValidationException, Exception {

		return responseHandler(this.builder.post(Entity.entity(obj, type)), generic);
	}

	/**
	 * 
	 * @param generic
	 * @return
	 */
	protected T post(final GenericType<T> generic) throws ValidationException, Exception {

		return responseHandler(this.builder.post(null), generic);
	}

	/**
	 * @param pathParams
	 */
	private void setPathParams(final List<String> pathParams) {
		if (pathParams != null && pathParams.size() > 0) {
			for (String string : pathParams) {
				this.wt = this.wt.path(string);
			}
		}
	}

	/**
	 * 
	 * @param queryParams
	 */
	private void setQueryParams(final MultivaluedMap<String, Object> queryParams) {
		if ((queryParams != null) && (queryParams.size() > 0)) {
			this.wt = this.wt.queryParams(queryParams);
		}
	}

	/**
	 * @param headerParams
	 */
	public void setHeaderParams(final Map<String, String> headerParams) {
		if ((headerParams != null) && (headerParams.size() > 0)) {
			for (final Entry<String, String> entry : headerParams.entrySet()) {
				if (entry.getValue() != null) {
					this.builder.header(entry.getKey(), entry.getValue());
				}
			}
		}
	}
}
