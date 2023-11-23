package backend.project.services;

import backend.project.entities.Personal;
import backend.project.entities.User;

import java.util.List;

public interface PersonalService {

    public Personal createPersonal(Personal personal);
    public Personal getPersonalById(Long id);

    public void setUserForPersonal(Personal personal, User user);

    public List<Personal> getAllPersonal();





}
