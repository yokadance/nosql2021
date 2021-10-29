package com.example.demo.repository;


import com.example.demo.model.Person;
import com.example.demo.model.Role;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, String> {
  Optional<Role> findByName(String name);
}
