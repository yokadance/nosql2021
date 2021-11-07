package com.example.nosql.repository;


import com.example.nosql.model.Role;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, String> {

  @Query("MATCH (r:Role{name: $nameRole}) RETURN r")
  Optional<Role> findByName(String nameRole);

  Optional<Role> findById(String id);

}
