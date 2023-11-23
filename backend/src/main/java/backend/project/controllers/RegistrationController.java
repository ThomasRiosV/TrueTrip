package backend.project.controllers;

import backend.project.dtos.DTOToken;
import backend.project.dtos.DTOUser;
import backend.project.entities.Personal;
import backend.project.entities.RegistrationRequest;
import backend.project.entities.User;
import backend.project.entities.UserPersonalResponse;
import backend.project.security.JwtUtilService;
import backend.project.security.SecurityUser;
import backend.project.services.UserService;
import backend.project.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegistrationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private JwtUtilService jwtUtilService;

  @Autowired
  private UserService userService;

  @Autowired
  private PersonalService personalService;

    @PostMapping("/users/registerpersonal")
  public ResponseEntity<UserPersonalResponse> createUser(@RequestBody RegistrationRequest request) {
    DTOUser userDto = request.getUser();
    Personal personalDto = request.getPersonal();

    User newUser = userService.register(userDto);
    Personal createdPersonal = personalService.createPersonal(personalDto);

    // Asocia el Personal creado con el nuevo User
    personalService.setUserForPersonal(createdPersonal, newUser);

    createdPersonal.setUser(newUser);

    UserPersonalResponse response = new UserPersonalResponse(newUser, createdPersonal);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }





}
