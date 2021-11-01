package com.example.nosql.mapper;

import com.example.nosql.dto.person.request.CreatePersonDto;
import com.example.nosql.dto.person.response.ReadPersonDto;
import com.example.nosql.model.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonMapper {
  Person createPersonDtoToPerson(CreatePersonDto createPersonDto);
  ReadPersonDto personToReadPersonDto(Person person);
}
