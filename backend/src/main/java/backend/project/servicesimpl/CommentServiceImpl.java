package backend.project.servicesimpl;

import backend.project.entities.Comment;
import backend.project.repositories.CommentRepository;
import backend.project.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public boolean deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> getCommentsForTravelPost(Long postId) {
        return commentRepository.findByTravelPostId(postId);

        /*
         * buscará todos los comentarios relacionados con una publicación
         * de viaje específica, utilizando el ID de la publicación de
         * viaje como parámetro. Puedes utilizar este método en tu servicio
         * para obtener los comentarios de una publicación de viaje específica.
         */
    }
}
