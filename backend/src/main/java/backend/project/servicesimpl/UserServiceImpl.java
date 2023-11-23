package backend.project.servicesimpl;

import backend.project.dtos.DTOUser;
import backend.project.entities.AuthorityName;
import backend.project.entities.User;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.AuthorityRepository;
import backend.project.repositories.UserRepository;
import backend.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;
  @Autowired
  AuthorityRepository authorityRepository;

  @Override
  public User findById(Long id) {
    User userFound = userRepository.findById(id).orElse(null);
    if (userFound == null) {
      throw new ResourceNotFoundException("There are no User with the id: "+String.valueOf(id));
    }
    return userFound;
  }

  @Override
  public User register(DTOUser user) {

    if (user.getUserName().length()>4 && user.getPassword().length()>4) {

      User userFound = userRepository.findByUserName(user.getUserName());
      if (userFound != null) {
        throw new KeyRepeatedDataException("User name can not be duplicated");
      };

      User newUser = new User();
      newUser.setUserName(user.getUserName());
      newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
      newUser.setEnabled(true);
      newUser.setPasswordLastUpdate(new Date());
      AuthorityName authorityName=AuthorityName.ROLE_STUDENT;
      if (user.getType().equals("ROLE_STUDENT")) authorityName= AuthorityName.ROLE_STUDENT;
      if (user.getType().equals("ROLE_TEACHER")) authorityName= AuthorityName.ROLE_TEACHER;
      if (user.getType().equals("ROLE_PRINCIPAL")) authorityName= AuthorityName.ROLE_PRINCIPAL;
      if (user.getType().equals("ADMIN")) authorityName= AuthorityName.ADMIN;
      if (user.getType().equals("CLIENT")) authorityName= AuthorityName.CLIENT;
      newUser.setAuthorities(
        List.of(
          authorityRepository.findByName(authorityName)
        )
      );

      return userRepository.save(newUser);
    } else {
      throw new IncompleteDataException("User name and password length can not be less than 4 characters");
    }
  }

  @Override
  public User changePassword(DTOUser user) {
    if (user.getUserName().length()>4 && user.getPassword().length()>4) {

      User userFound = userRepository.findByUserName(user.getUserName());
      if (userFound == null) {
        throw new ResourceNotFoundException("User name can not be found");
      };

      userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
      userFound.setPasswordLastUpdate(new Date());
      return userRepository.save(userFound);
    } else {
      throw new IncompleteDataException("User name and password length can not be less than 4 characters");
    }
  }
}
