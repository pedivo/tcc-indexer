package br.com.machado.pedro.ivo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public abstract class MongoAbstractService<T, TPk> {

	@Autowired
	private MongoTemplate	mongoTemplate;

	private Class<T>			clazz;

	public MongoAbstractService(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void save(T entity) {
		mongoTemplate.save(entity);
	}

	public void delete(T entity) {
		mongoTemplate.remove(entity);
	}
	
	public void delete(Query query) {
		mongoTemplate.remove(query, clazz);
	}

	protected long count(Query query) {
		return mongoTemplate.count(query, clazz);
	}

	protected List<T> find(Query query) {
		return mongoTemplate.find(query, clazz);
	}

	protected T get(Query query) {
		return mongoTemplate.findOne(query, clazz);
	}

	public T findById(TPk key) {
		return mongoTemplate.findById(key, clazz);
	}
}
