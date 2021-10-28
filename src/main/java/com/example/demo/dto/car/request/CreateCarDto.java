package com.example.demo.dto.car.request;

import com.example.demo.model.CarType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCarDto {

  private String make;
  private int numberOfSeats;
  private CarType type;
}
