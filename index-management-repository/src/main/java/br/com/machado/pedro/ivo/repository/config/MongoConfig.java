package br.com.machado.pedro.ivo.repository.config;

import java.util.ResourceBundle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan("com.meplis")
public class MongoConfig extends AbstractMongoConfiguration {

	private ResourceBundle	config	= ResourceBundle.getBundle("persistence-config");

	@Override
	public String getDatabaseName() {
		return config.getString("mongodb.schema");
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(config.getString("mongodb.url"));
	}

	@Override
	protected String getMappingBasePackage() {
		return config.getString("mongodb.mappingbasepackage");
	}
}
