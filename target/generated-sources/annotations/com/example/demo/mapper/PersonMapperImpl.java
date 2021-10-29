package com.example.demo.mapper;

import com.example.demo.dto.person.request.CreatePersonDto;
import com.example.demo.dto.person.response.ReadPersonDto;
import com.example.demo.model.Person;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-29T20:31:15-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person createPersonDtoToPerson(CreatePersonDto createPersonDto) {
        if ( createPersonDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setName( createPersonDto.getName() );
        person.setEmail( createPersonDto.getEmail() );
        person.setPassword( createPersonDto.getPassword() );

        return person;
    }

    @Override
    public ReadPersonDto personToReadPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        ReadPersonDto readPersonDto = new ReadPersonDto();

        readPersonDto.setId( person.getId() );
        readPersonDto.setName( person.getName() );
        readPersonDto.setEmail( person.getEmail() );
        readPersonDto.setPassword( person.getPassword() );
        readPersonDto.setCreatedAt( person.getCreatedAt() );
        readPersonDto.setUpdatedAt( person.getUpdatedAt() );

        return readPersonDto;
    }
}
