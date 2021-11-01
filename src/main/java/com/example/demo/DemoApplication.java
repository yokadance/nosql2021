package com.example.demo;

import com.example.demo.model.Message;
import com.example.demo.model.Person;
import com.example.demo.model.UserContext;
import com.example.demo.repository.PersonRepository;
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
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  @RequestScope
  public UserContext requestUserDataContext() {
    return new UserContext();
  }

  @Bean
  CommandLineRunner demo(PersonRepository personRepository) {
    return args -> {
      personRepository.deleteAll();


      var greg = new Person("Greg", "greg@greg.com", "test123");
      var roy = new Person("Roy","roy@roy.com", "test123");
      var craig = new Person("Craig","craig@graig.com", "test123");
      var mess = new Message("100","Exito!" );

      personRepository.save(greg);
      personRepository.save(roy);
      personRepository.save(craig);

    };
  }
}
