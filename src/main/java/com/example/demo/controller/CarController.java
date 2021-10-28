package com.example.demo.controller;

import com.example.demo.dto.car.request.CreateCarDto;
import com.example.demo.dto.car.response.ReadCarDto;
import com.example.demo.dto.person.response.ReadPersonDto;
import com.example.demo.service.CarService;
import com.example.demo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cars")
@SecurityRequirement(name = "bearerAuth")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  @Operation(summary = "Este endpoint lista autos")
  ResponseEntity<List<ReadCarDto>> listCars() {
    return ResponseEntity.ok(this.carService.listCars());
  }

  @PostMapping //EndPOINT
  @Operation(summary = "Crear un Auto")
  ResponseEntity<ReadCarDto> createCar(@RequestBody CreateCarDto createCarDto) { // ReadCarDto CREADO EN CarService transformado por Mapper
    return ResponseEntity.ok(this.carService.createCar(createCarDto));
  }
}
