package backend.project.repositories;

import backend.project.entities.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {



}
