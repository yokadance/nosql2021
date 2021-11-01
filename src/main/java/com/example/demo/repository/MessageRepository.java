package com.example.demo.repository;

import com.example.demo.model.Message;
import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends Neo4jRepository<Message, String> {
    Optional<Message> findAllBy (String id);

}