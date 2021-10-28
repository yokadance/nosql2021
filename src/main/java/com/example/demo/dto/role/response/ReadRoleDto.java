package com.example.demo.dto.role.response;

import com.example.demo.model.CarType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadRoleDto {

  private Long id;
  private String name;
}
