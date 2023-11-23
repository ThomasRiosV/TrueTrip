package backend.project.servicesimpl;

import backend.project.entities.Personal;
import backend.project.entities.User;
import backend.project.repositories.PersonalRepository;
import backend.project.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public Personal createPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal getPersonalById(Long id) {
        try {
            return personalRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null; // Devuelve null si no se encuentra el Personal con el ID dado
        }
    }
      @Override
    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }

  @Transactional
  @Override
  public void setUserForPersonal(Personal personal, User user) {
    personal.setUser(user);
    // No es necesario realizar un commit manual con anotaciones @Transactional.
  }



}


