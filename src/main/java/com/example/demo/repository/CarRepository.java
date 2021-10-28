package com.example.demo.repository;

import com.example.demo.model.Car;
import com.example.demo.model.Person;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends Neo4jRepository<Car, String> {
  Optional<Car> findByMake(String make);
}
