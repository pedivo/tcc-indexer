package br.com.machado.pedro.ivo.repository;

import org.springframework.stereotype.Repository;
import br.com.machado.pedro.ivo.entity.IndexEntity;

@Repository
public class IndexRepository extends MongoAbstractService<IndexEntity, String>{

	public IndexRepository() {
		super(IndexEntity.class);
	}

}
