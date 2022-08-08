package com.cirbal.portfel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication

@EnableJpaRepositories("com.cirbal.portfel.repositories")


public class CrudJwtPortfelApplication {

	private final static Logger log = LoggerFactory.getLogger(CrudJwtPortfelApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CrudJwtPortfelApplication.class, args);
		System.out.println("Benvenidos мать ублюдок");
	}
}
