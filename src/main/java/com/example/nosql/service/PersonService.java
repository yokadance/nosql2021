package com.example.nosql.service;

import com.example.nosql.dto.person.request.CreatePersonDto;
import com.example.nosql.dto.person.response.ReadPersonDto;
import com.example.nosql.exception.ApiException;
import com.example.nosql.mapper.PersonMapper;
import com.example.nosql.repository.MessageRepository;
import com.example.nosql.repository.PersonRepository;
import com.example.nosql.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final RoleRepository roleRepository;
    private final MessageRepository messageRepository;

    public PersonService(
            PersonRepository personRepository,
            PersonMapper personMapper,
            RoleRepository roleRepository,
            MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.roleRepository = roleRepository;
        this.messageRepository = messageRepository;
    }

    public ReadPersonDto createPerson(CreatePersonDto createPersonDto) throws ApiException {
        var a = this.personMapper.createPersonDtoToPerson(createPersonDto);
        var exist =
                this.personRepository.findByEmail(a.getEmail());
        if (exist.isEmpty()) {
            var b = this.personRepository.save(a);
            return this.personMapper.personToReadPersonDto(b);
        } else
            throw new ApiException(HttpStatus.ALREADY_REPORTED, this.messageRepository.findMessagesByErrorCode("101").get().getMessage());

    }

    public List<ReadPersonDto> listPersons() {
        var persons = this.personRepository.findAll();
        return persons.stream().map(this.personMapper::personToReadPersonDto).collect(Collectors.toList());
    }

    public String associatePersonAndRol(String email, String idRole) throws ApiException {

        System.out.println(" Verifica Persona ");
        var person =
                this.personRepository.findByEmail(email).orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND, this.messageRepository.findMessagesByErrorCode("102").get().getMessage()));
                //this.personRepository.findById(idPerson)
                 //       .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, this.messageRepository.findMessagesByErrorCode("102").get().getMessage()));

        System.out.println(" Verifica Rol ");
        var role =
                this.roleRepository.findById(idRole)
                        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, this.messageRepository.findMessagesByErrorCode("103").get().getMessage()));

        //if (person.getRoles().contains(role)) {
        //  throw new ApiException(HttpStatus.CONFLICT, "Ya tiene el rol agregado");
        //}
        System.out.println(" Agrega Rol a Persona ");
        person.addRole(role);
        System.out.println(" Agrego Rol a Persona ");
        var personWithRole = this.personRepository.save(person);
        System.out.println(" GuardO Persona ");
        return "OK";
    }


    public String deleteRolToPerson(String email, String idRole) throws ApiException {

        System.out.println(" Verifica Persona ");
        var person =
                this.personRepository.findByEmail(email).orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND, this.messageRepository.findMessagesByErrorCode("102").get().getMessage()));
        System.out.println(" Verifica Rol ");
        var role =
                this.roleRepository.findById(idRole)
                        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, this.messageRepository.findMessagesByErrorCode("103").get().getMessage()));
        personRepository.removeRole(email, idRole);
        return "OK";
    }
}
