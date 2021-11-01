package com.example.nosql.service;

import com.example.nosql.dto.auth.request.AuthRequest;
import com.example.nosql.dto.auth.response.TokenDto;
import com.example.nosql.exception.ApiException;
import com.example.nosql.repository.MessageRepository;
import com.example.nosql.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final PersonRepository personRepository;
  private final MessageRepository messageRepository;


  public AuthService(PersonRepository personRepository, MessageRepository messageRepository) {
      this.messageRepository = messageRepository;
      this.personRepository = personRepository;
  }


  public TokenDto login(AuthRequest authRequest) throws ApiException {
    TokenDto tokenDto = new TokenDto();
    tokenDto.setToken("false");
    var person = //busco en BD el mail findByEmail
      this.personRepository.findByEmail(authRequest.getEmail())
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, this.messageRepository.findMessagesByErrorCode("104").get().getMessage()));

     if (authRequest.getPassword().equals(person.getPassword())){
       tokenDto.setToken("true");
     }

      return tokenDto;
  }
}
