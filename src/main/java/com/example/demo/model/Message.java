package com.example.demo.model;
import com.example.demo.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@NoArgsConstructor
public class Message  {
    @Id
    private String errorCode;
    private String message;

    public Message(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}



