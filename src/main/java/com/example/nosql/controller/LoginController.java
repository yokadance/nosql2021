package com.example.nosql.controller;


import com.example.nosql.dto.auth.request.AuthRequest;
import com.example.nosql.dto.auth.response.TokenDto;
import com.example.nosql.exception.ApiException;
import com.example.nosql.service.AuthService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
class LoginController {

  private final AuthService authService;

  LoginController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/login")
  @ApiResponses(
          value = {
                  @ApiResponse(
                          responseCode = "200",
                          content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TokenDto.class)) }
                  )
          }
  )
  ResponseEntity<TokenDto> login(
          @RequestBody @Valid AuthRequest authRequestDto
  ) throws ApiException {
    var authTokenDto = this.authService.login(authRequestDto);

    return ResponseEntity.ok(authTokenDto);
  }
}
