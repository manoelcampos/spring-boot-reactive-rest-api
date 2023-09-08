package com.example.reactiverestapi;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
public class ReactiveRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRestApiApplication.class, args);
	}

	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		final var initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);

		final var populator = new CompositeDatabasePopulator();
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
		initializer.setDatabasePopulator(populator);

		return initializer;
	}
}
