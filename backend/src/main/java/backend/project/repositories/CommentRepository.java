package backend.project.repositories;

import backend.project.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTravelPostId(Long travelPostId);
}
