package com.example.demo.controller;

import com.example.demo.dto.ApiErrorResponse;
import com.example.demo.dto.person.request.CreatePersonDto;
import com.example.demo.dto.person.response.ReadPersonDto;
import com.example.demo.exception.ApiException;
import com.example.demo.model.UserContext;
import com.example.demo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
@Validated
public class PersonController {

  @Resource(name = "requestUserDataContext")
  private UserContext userContext;

  private final PersonService personService;

  public PersonController(PersonService personService) {

    this.personService = personService;
  }

  @GetMapping
  @Operation(summary = "Este endpoint lista personas")
  ResponseEntity<List<ReadPersonDto>> listPersons() {
    return ResponseEntity.ok(this.personService.listPersons());
  }

  @PostMapping
  @Operation(summary = "Este endpoint crea una persona")
  ResponseEntity<ReadPersonDto> createPerson(@RequestBody @Valid CreatePersonDto createPersonDto) throws ApiException {
    var persistedPerson = this.personService.createPerson(createPersonDto);
    return ResponseEntity.ok(persistedPerson);
  }

  @PostMapping("/{idPersona}/roles/{idRol}")
  @Operation(summary = "Este endpoint asocia perosnas con roles")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "404",
        content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))
        }
      ),
      @ApiResponse(
        responseCode = "409",
        content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))
        }
      )
    }
  )
  public String associatePersonAndRole(@PathVariable String idPersona, @PathVariable String idRol) throws ApiException {
    this.personService.associatePersonAndRol(idPersona, idRol);
    return "IDPersona: " + idPersona + " IdRol: " + idRol;
  }
}
