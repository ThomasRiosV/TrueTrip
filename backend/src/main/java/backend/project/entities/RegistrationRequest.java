package backend.project.entities;

import backend.project.dtos.DTOUser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {
  private DTOUser user;
  private Personal personal;
}

