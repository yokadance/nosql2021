package com.example.demo.mapper;

import com.example.demo.dto.car.request.CreateCarDto;
import com.example.demo.dto.car.response.ReadCarDto;
import com.example.demo.model.Car;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-23T18:55:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public ReadCarDto carToReadCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        ReadCarDto readCarDto = new ReadCarDto();

        if ( car.getId() != null ) {
            readCarDto.setId( Long.parseLong( car.getId() ) );
        }
        readCarDto.setMake( car.getMake() );
        readCarDto.setNumberOfSeats( car.getNumberOfSeats() );
        readCarDto.setType( car.getType() );

        return readCarDto;
    }

    @Override
    public Car createCarDtoTOCar(CreateCarDto createCarDto) {
        if ( createCarDto == null ) {
            return null;
        }

        Car car = new Car();

        car.setMake( createCarDto.getMake() );
        car.setNumberOfSeats( createCarDto.getNumberOfSeats() );
        car.setType( createCarDto.getType() );

        return car;
    }
}
