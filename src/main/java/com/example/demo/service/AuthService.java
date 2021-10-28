package com.example.demo.service;

import com.example.demo.dto.auth.response.TokenDto;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.PersonRepository;
import com.example.demo.util.JwtUtil;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.ErrorCode;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import java.io.IOException;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final PersonRepository personRepository;
  private final JwtUtil jwtUtil;

  public AuthService(PersonRepository personRepository, JwtUtil jwtUtil) throws IOException {
    this.personRepository = personRepository;
    this.jwtUtil = jwtUtil;

    //TRAIGO EL ARCHIVO
    var classLoader = getClass().getClassLoader();
    var inputStream = classLoader.getResourceAsStream("serviceAccountKey.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
      .setCredentials(GoogleCredentials.fromStream(inputStream))
      .build();

    FirebaseApp.initializeApp(options);
  }

  private String verifyFirebaseToken(String firebaseToken) throws ApiException {
    FirebaseToken token;
    try {
      token = FirebaseAuth.getInstance().verifyIdToken(firebaseToken);
    } catch (FirebaseAuthException e) {
      throw new ApiException(HttpStatus.FORBIDDEN, " invalid Token");
    }
    var name = token.getName();
    System.out.println(" Id: " + name);
    return name;
  }

  public TokenDto login(String firebaseToken) throws ApiException {
    var name = verifyFirebaseToken(firebaseToken); //MAIL
    var person = //busco en BD el mail findByEmail
      this.personRepository.findByName(name)
        .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));

    var claims = new HashMap<String, Object>();
    claims.put("extraData", person.getId());
    return new TokenDto(this.jwtUtil.createToken(claims, person.getName()));
  }
}
