package backend.project.repositories;

import backend.project.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {


}
