package br.com.machado.pedro.ivo.jaxrs;

import java.util.Arrays;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import br.com.machado.pedro.ivo.beans.enums.OperationType;
import br.com.machado.pedro.ivo.beans.exceptions.ValidationException;
import br.com.machado.pedro.ivo.client.ConnectorConstants;
import br.com.machado.pedro.ivo.client.IndexClient;
import br.com.machado.pedro.ivo.client.SuccessResult;
import br.com.machado.pedro.ivo.client.dto.IndexDTO;

public class IndexRestClient extends Application implements IndexClient {

	public IndexRestClient() {
		super();
	}
	
	@Override
	public void add(Long totalTime, OperationType type, String engine, String taskId, Map<String, Object> metadata) throws ValidationException, Exception {
		String[] pathParams = { ConnectorConstants.INDEX_RESOURCE };

		IndexDTO dto = new IndexDTO();
		dto.setEngine(engine);
		dto.setMetadata(metadata);
		dto.setTaskId(taskId);
		dto.setTotalTime(totalTime);
		dto.setType(type);
		
		GenericType<SuccessResult> response = new GenericType<SuccessResult>() {};
		JAXRSConnector<SuccessResult> connector = new JAXRSConnector<SuccessResult>(API_URL, Arrays.asList(pathParams));
		connector.post(response, dto);
	}
}
