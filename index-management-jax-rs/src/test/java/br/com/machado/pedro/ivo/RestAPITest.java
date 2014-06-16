package br.com.machado.pedro.ivo;

import org.junit.Test;
import br.com.machado.pedro.ivo.beans.enums.OperationType;
import br.com.machado.pedro.ivo.beans.exceptions.ValidationException;
import br.com.machado.pedro.ivo.client.IndexClient;
import br.com.machado.pedro.ivo.jaxrs.IndexRestClient;


public class RestAPITest {

	@Test
	public void addTest() throws ValidationException, Exception {
		IndexClient client = new IndexRestClient();
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
		client.add(100L, OperationType.DELETE, "teste-01", "task-01", null);
	}

}
