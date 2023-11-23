package backend.project.repositories;

import backend.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String userName);

  //  Optional<User> findByUserName(String userName);
}
