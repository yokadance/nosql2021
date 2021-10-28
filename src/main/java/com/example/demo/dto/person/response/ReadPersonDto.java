package com.example.demo.dto.person.response;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadPersonDto {

  private String Id;
  private String name;
  private String email;
  private String password;
  private Date createdAt;
  private Date updatedAt;
}
