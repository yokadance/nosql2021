package com.example.nosql.repository;

import com.example.nosql.model.Message;

import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends Neo4jRepository<Message, String> {
    Optional<Message> findMessagesByErrorCode(String errorCode);

}