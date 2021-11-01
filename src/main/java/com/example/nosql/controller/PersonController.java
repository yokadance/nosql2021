package com.example.nosql.controller;

import com.example.nosql.dto.ApiErrorResponse;
import com.example.nosql.dto.person.request.CreatePersonDto;
import com.example.nosql.dto.person.response.ReadPersonDto;
import com.example.nosql.exception.ApiException;
import com.example.nosql.model.UserContext;
import com.example.nosql.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;

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

  @PostMapping("/{email}/roleAdd/{idRol}")
  @Operation(summary = "Este endpoint asocia personas con roles")
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
  public String associatePersonAndRole(@PathVariable String email, @PathVariable String idRol) throws ApiException {
    this.personService.associatePersonAndRol(email, idRol);
    return "Email: " + email + " IdRol: " + idRol;
  }





  @PostMapping("/{email}/roleRemove/{idRol}")
  @Operation(summary = "Este endpoint elimina un rol a una persona que posee uno.")
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
  public String deleteRolToPerson(@PathVariable String email, @PathVariable String idRol) throws ApiException {
    this.personService.deleteRolToPerson(email, idRol);
    return "Email: " + email + " IdRol: " + idRol;
  }
}
