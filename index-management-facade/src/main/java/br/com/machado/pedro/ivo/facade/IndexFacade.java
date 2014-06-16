package br.com.machado.pedro.ivo.facade;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.machado.pedro.ivo.beans.exceptions.ValidationException;
import br.com.machado.pedro.ivo.client.dto.IndexDTO;
import br.com.machado.pedro.ivo.entity.IndexEntity;
import br.com.machado.pedro.ivo.repository.IndexRepository;

@Component
public class IndexFacade {

	@Autowired
	private IndexRepository	repository;

	private void validate(IndexDTO index) throws ValidationException {
		if (index.getEngine() == null) { throw new ValidationException("Engine is a mandatory field"); }
		if (index.getTaskId() == null) { throw new ValidationException("Task ID is a mandatory field"); }
		if (index.getType() == null) { throw new ValidationException("Type is a mandatory field"); }
		if (index.getTotalTime() == null) { throw new ValidationException("Total is a mandatory field"); }
	}

	public void save(IndexDTO index) throws ValidationException {
		validate(index);
		IndexEntity entity = new IndexEntity();
		entity.setEngine(index.getEngine());
		entity.setTaskId(index.getTaskId());
		entity.setTotalTime(index.getTotalTime());
		entity.setType(index.getType());
		entity.setMetadata(index.getMetadata());
		entity.setUuid(new Date().getTime() + "-" + UUID.randomUUID().toString());
		
		repository.save(entity);
	}
}
