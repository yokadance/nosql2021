package com.example.nosql.model;

import java.util.HashSet;
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
public class Person extends BaseEntity {

  private String name;
  private String email;
  private String password;



  @Relationship(type = "IS", direction = Relationship.Direction.OUTGOING)
  public Set<Role> roles;


  public Person(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }



  public void addRole(Role role) {
    if (roles == null) {
      roles = new HashSet<>();
    }
    roles.add(role);
  }


}
