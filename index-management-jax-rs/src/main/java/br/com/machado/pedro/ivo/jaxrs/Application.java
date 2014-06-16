package br.com.machado.pedro.ivo.jaxrs;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;

public class Application {

	protected static final String	API_URL;

	static {
		API_URL = "http://127.0.0.1:8080/idx/";
	}

	private Map<String, String>		header;

	public Application() {
		header = new HashMap<String, String>();
		header.put("Accept", MediaType.APPLICATION_JSON);
	}

	public Map<String, String> getHeaders() {
		return header;
	}

	public void addHeader(String key, String value) {
		if (header == null) {
			header = new HashMap<String, String>();
		}
		header.put(key, value);
	}

}
