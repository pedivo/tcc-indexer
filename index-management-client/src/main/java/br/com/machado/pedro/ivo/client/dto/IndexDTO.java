package br.com.machado.pedro.ivo.client.dto;

import java.util.Map;
import br.com.machado.pedro.ivo.beans.enums.OperationType;

public class IndexDTO {

	private Long								totalTime;
	private OperationType				type;
	private String							engine;
	private String							taskId;
	private Map<String, Object>	metadata;

	public Long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}

}
