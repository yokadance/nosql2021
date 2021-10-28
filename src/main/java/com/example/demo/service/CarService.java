package com.example.demo.service;

import com.example.demo.dto.car.request.CreateCarDto;
import com.example.demo.dto.car.response.ReadCarDto;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repository.CarRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public CarService(CarRepository carRepository, CarMapper carMapper) {
    this.carRepository = carRepository;
    this.carMapper = carMapper;
  }

  public List<ReadCarDto> listCars() {
    var cars = this.carRepository.findAll();

    return cars.stream().map(this.carMapper::carToReadCarDto).collect(Collectors.toList());
  }

  public ReadCarDto createCar(CreateCarDto createCarDto) {
    var car = this.carMapper.createCarDtoTOCar(createCarDto);
    this.carRepository.save(car);
    return this.carMapper.carToReadCarDto(car);
  }
  /*    public ReadCarDto asociateCar(CreateCarDto createCarDto) {
        var car = this.carMapper.createCarDtoTOCar(createCarDto);
        this.carRepository.save(car);
        return this.carMapper.carToReadCarDto(car);
    }*/

}
