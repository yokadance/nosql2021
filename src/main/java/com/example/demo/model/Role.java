package com.example.demo.model;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@EqualsAndHashCode(callSuper = true)
@Node
@Data
@NoArgsConstructor
public class Role extends BaseEntity {

  private String name;

  @Relationship(type = "IS", direction = Relationship.Direction.INCOMING)
  public Set<Person> person;

  public Role(String name) {
    this.name = name;
  }
}
