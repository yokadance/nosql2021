package com.example.demo.service;

import com.example.demo.dto.auth.request.AuthRequest;
import com.example.demo.dto.auth.response.TokenDto;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final PersonRepository personRepository;


  public AuthService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }


  public TokenDto login(AuthRequest authRequest) throws ApiException {
    TokenDto tokenDto = new TokenDto();
    tokenDto.setToken("false");
    var person = //busco en BD el mail findByEmail
      this.personRepository.findByEmail(authRequest.getEmail())
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));

     if (authRequest.getPassword().equals(person.getPassword())){
       tokenDto.setToken("true");
     }

      return tokenDto;
  }
}
