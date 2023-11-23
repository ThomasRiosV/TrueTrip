package backend.project.services;

import backend.project.entities.Comment;

import java.util.List;

public interface CommentService {

    public Comment addComment(Comment comment);

    public boolean deleteComment(Long id);

    public List<Comment> getCommentsForTravelPost(Long postId);
}
