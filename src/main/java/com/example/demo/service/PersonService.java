package com.example.demo.service;

import com.example.demo.dto.person.request.CreatePersonDto;
import com.example.demo.dto.person.response.ReadPersonDto;
import com.example.demo.exception.ApiException;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.RoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;
  private final PersonMapper personMapper;
  private final RoleRepository roleRepository;

  public PersonService(
    PersonRepository personRepository,
    PersonMapper personMapper,
    RoleRepository roleRepository
  ) {
    this.personRepository = personRepository;
    this.personMapper = personMapper;
    this.roleRepository = roleRepository;
  }

  public ReadPersonDto createPerson(CreatePersonDto createPersonDto) {
    var a = this.personMapper.createPersonDtoToPerson(createPersonDto);
    var b = this.personRepository.save(a);
    return this.personMapper.personToReadPersonDto(b);
  }

  public List<ReadPersonDto> listPersons() {
    var persons = this.personRepository.findAll();
    return persons.stream().map(this.personMapper::personToReadPersonDto).collect(Collectors.toList());
  }

  public String associatePersonAndRol(String idPerson, String idRole) throws ApiException {

    System.out.println(" Verifica Persona ");
    var person =
      this.personRepository.findById(idPerson)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Persona no encontrada"));

    System.out.println(" Verifica Rol ");
    var role =
      this.roleRepository.findById(idRole)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Rol no encontrado"));

    //if (person.getRoles().contains(role)) {
    //  throw new ApiException(HttpStatus.CONFLICT, "Ya tiene el rol agregado");
    //}
    System.out.println(" Agrega Rol a Persona ");
    person.addRole(role);
    System.out.println(" AgregO Rol a Persona ");
    var personWithRole = this.personRepository.save(person);
    System.out.println(" GuardO Persona ");
    return "OK";
  }
}
