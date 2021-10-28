package com.example.demo.dto.person.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePersonDto {

  @NotBlank(message = "all fields must be contian data")
  private String name;
  private String email;
  private String password;
}
