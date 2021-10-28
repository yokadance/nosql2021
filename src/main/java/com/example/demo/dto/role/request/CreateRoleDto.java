package com.example.demo.dto.role.request;

import com.example.demo.model.CarType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateRoleDto {

  private Long id;
  private String name;
}