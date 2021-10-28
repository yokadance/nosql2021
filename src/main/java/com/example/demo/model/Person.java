package com.example.demo.model;

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

/*  @Relationship(type = "TEAMMATE", direction = Relationship.Direction.INCOMING)
  private Set<Person> teammates;

  @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
  public Set<Car> cars;*/

  @Relationship(type = "IS", direction = Relationship.Direction.OUTGOING)
  public Set<Role> roles;

  public Person(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  /*public void worksWith(Person person) {
    if (teammates == null) {
      teammates = new HashSet<>();
    }
    teammates.add(person);
  }*/



  public void addRole(Role role) {
    if (roles == null) {
      roles = new HashSet<>();
    }
    roles.add(role);
  }

  public void beforeSave() {
    System.out.println(" PRUEBA ");
  }
}
