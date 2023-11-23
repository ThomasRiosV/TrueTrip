package backend.project.repositories;

import backend.project.entities.TravelCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelCategoryRepository extends JpaRepository<TravelCategory, Long> {

}

