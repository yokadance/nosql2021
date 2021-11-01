package com.example.nosql.repository;

import com.example.nosql.model.Person;

import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends Neo4jRepository<Person, String> {

  Optional<Person> findByName(String name);
  Optional<Person> findByEmail(String email);
  //@Query("MATCH (u:User{canonicalName:$canonicalName})-[g:USES]->(:GitPlatform) DELETE g")
  @Query("MATCH (p:Person {email: $email})-[r:IS]->(:Role{id: $id}) DELETE r")
  void removeRole(String email, String id);

}
