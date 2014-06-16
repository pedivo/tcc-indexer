package br.com.machado.pedro.ivo.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.GZIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.machado.pedro.ivo.client.ConnectorConstants;
import br.com.machado.pedro.ivo.client.dto.IndexDTO;
import br.com.machado.pedro.ivo.facade.IndexFacade;

@Component
@Path(ConnectorConstants.INDEX_RESOURCE)
@GZIP
@Produces({ MediaType.APPLICATION_JSON })
public class IndexResource {

	@Autowired
	private IndexFacade	facade;

	@POST
	public Response save(IndexDTO index) {
		facade.save(index);
		return Response.status(200).build();
	}
}
