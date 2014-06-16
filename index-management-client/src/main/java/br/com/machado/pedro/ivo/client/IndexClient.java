package br.com.machado.pedro.ivo.client;

import java.util.Map;
import br.com.machado.pedro.ivo.beans.enums.OperationType;
import br.com.machado.pedro.ivo.beans.exceptions.ValidationException;

public interface IndexClient {

	public void add(Long totalTime, OperationType type, String engine, String taskId, Map<String, Object> metadata) throws ValidationException, Exception;
}
