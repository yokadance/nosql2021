package com.example.demo.repository;

import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, String> {
  // @Query("MATCH (n:Person) where n.name='MathiasZunin' return n;")
  //Person findGreg();

  Optional<Person> findByName(String name);
 // List<Person> findByTeammatesName(String name);
}
