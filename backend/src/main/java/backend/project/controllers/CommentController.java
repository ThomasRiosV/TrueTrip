package backend.project.controllers;

import backend.project.entities.Comment;
import backend.project.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping("/comment/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        // Implementa la lógica para agregar un comentario a una publicación de viaje
        Comment addedComment = commentService.addComment(comment);
        return ResponseEntity.ok(addedComment);
    }

  /* @PutMapping("/comment/update/{commentId}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable Long commentId,
            @RequestBody Comment updatedComment) {
        // Implementa la lógica para editar un comentario existente
        Comment updated = commentService.updateComment(commentId, updatedComment);
        return ResponseEntity.ok(updated);
    }*/

    @DeleteMapping("/comment/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        // Implementa la lógica para eliminar un comentario
        boolean deleted = commentService.deleteComment(commentId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/comment/travel-post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsForTravelPost(@PathVariable Long postId) {
        // Implementa la lógica para ver todos los comentarios de una publicación de viaje
        List<Comment> comments = commentService.getCommentsForTravelPost(postId);
        return ResponseEntity.ok(comments);
    }
}