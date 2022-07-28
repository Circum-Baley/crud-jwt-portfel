package com.cirbal.portfel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


//import com.cirbal.knsulting.repositories.RoleRepository;
//import com.cirbal.knsulting.repositories.UserInRoleRepository;
//import com.cirbal.knsulting.repositories.UserRepository;
//import com.github.javafaker.Faker;
//import com.cirbal.knsulting.entities.Role;
//import com.cirbal.knsulting.entities.User;
//import com.cirbal.knsulting.entities.UserInRole;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
//@ComponentScan({ "com.cirbal.portfel.controllers,com.cirbal.knsulting.config,com.cirbal.knsulting.services" }) // to
																													// scan
																													// packages
																													// mentioned
//@ComponentScan({})
// /Login-Security-CRS/src/main/java/com/userlogin/userApp/LoginSecurityCrsApplication.java
@EnableJpaRepositories("com.cirbal.portfel.repositories")


public class CrudJwtPortfelApplication {//implements ApplicationRunner {

	private final static Logger log = LoggerFactory.getLogger(CrudJwtPortfelApplication.class);
//
//	@Autowired(required = true)
//	private Faker faker;
//
//	@Autowired
//	private UserRepository userRepository;

//	@Autowired
//	private UserInRoleRepository userInRoleRepository;

	@Autowired
//	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudJwtPortfelApplication.class, args);
		System.out.println("Benvenidos мать ублюдок");
	}



//	void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("forward:/index");
//	}

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		Role roles[] = { new Role("ADMIN"), new Role("ROOT"), new Role("USER"), new Role("SUPPORT") };
//
//		for (Role role : roles) {
//			roleRepository.save(role);
//		}
//
//		for (int i = 0; i < 5; i++) {
//			User user = new User();
//			user.setUsername(faker.name().username());
//			user.setPassword(faker.dragonBall().character());
//			User created = userRepository.save(user);
//			UserInRole userInRole = new UserInRole(created, roles[new Random().nextInt(4)]);
//			log.info("Usuario Creado - Username {} - Password {} - rol {}", created.getUsername(),
//					created.getPassword(), userInRole.getRole().getName());
//			userInRoleRepository.save(userInRole);
//		}
//
//	}

}
