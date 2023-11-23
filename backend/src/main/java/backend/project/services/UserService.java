package backend.project.services;

import backend.project.dtos.DTOUser;
import backend.project.entities.User;

public interface UserService {

  public User findById(Long id);

  public User register(DTOUser user);

  public User changePassword(DTOUser user);
}
