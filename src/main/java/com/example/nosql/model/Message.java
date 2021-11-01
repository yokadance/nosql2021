package com.example.nosql.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@EqualsAndHashCode()
@Node
@Data
@NoArgsConstructor
public class Message extends BaseEntity {

    private String errorCode;
    private String message;

    public Message(String errorCode, String message) {

        this.errorCode = errorCode;
        this.message = message;
    }
}



