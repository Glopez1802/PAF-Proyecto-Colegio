package com.colegio.ProyectoColegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProyectoColegioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoColegioApplication.class, args);
	}

}
