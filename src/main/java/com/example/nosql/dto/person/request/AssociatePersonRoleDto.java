package com.example.nosql.dto.person.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
public class AssociatePersonRoleDto {

  @NotBlank(message = "all fields must be contian data")
  private String email;
  private String password;
  private List<String> nameRoles;



}
