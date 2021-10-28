package com.example.demo.mapper;

import com.example.demo.dto.car.request.CreateCarDto;
import com.example.demo.dto.car.response.ReadCarDto;
import com.example.demo.model.Car;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CarMapper {
  ReadCarDto carToReadCarDto(Car car);

  Car createCarDtoTOCar(CreateCarDto createCarDto);
}
