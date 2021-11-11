package com.example.nosql;

import com.example.nosql.model.Message;
import com.example.nosql.model.Person;
import com.example.nosql.model.Role;
import com.example.nosql.model.UserContext;
import com.example.nosql.repository.MessageRepository;
import com.example.nosql.repository.PersonRepository;
import com.example.nosql.repository.RoleRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@OpenAPIDefinition(
  info = @Info(
    title = "NoSQL 2021",
    version = "v1",
    description = "Obligatorio 2 NoSQL 2021"
  )
)
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@EnableNeo4jAuditing()
public class StartApplication {

  public static void main(String[] args) {
    SpringApplication.run(StartApplication.class, args);
  }

  @Bean
  @RequestScope
  public UserContext requestUserDataContext() {
    return new UserContext();
  }

  @Bean
  CommandLineRunner start(PersonRepository personRepository, MessageRepository messageRepository, RoleRepository roleRepository) {
    return args -> {
      personRepository.deleteAll();
      messageRepository.deleteAll();

//
      var greg = new Person("Greg", "greg@greg.com", "test123");
      var roy = new Person("Roy","roy@roy.com", "test123");
      var craig = new Person("Craig","craig@craig.com", "test123");
      var mess = new Message("101","Error! Este email ya esta registrado" );
      var mess1 = new Message("102","Error! Ese usuario no encontrado, verifique su email" );
      var mess2 = new Message("103","Error! No posee ese rol asignado" );
      var mess3 = new Message("104","Error! La contraseña no coincide" );




      personRepository.save(greg);
      personRepository.save(roy);
      personRepository.save(craig);
      messageRepository.save(mess);
      messageRepository.save(mess1);
      messageRepository.save(mess2);
      messageRepository.save(mess3);


    };
  }



}
