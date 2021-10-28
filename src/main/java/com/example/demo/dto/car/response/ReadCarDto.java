package com.example.demo.dto.car.response;

import com.example.demo.model.CarType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadCarDto {

  private Long id;
  private String make;
  private int numberOfSeats;
  private CarType type;
}
