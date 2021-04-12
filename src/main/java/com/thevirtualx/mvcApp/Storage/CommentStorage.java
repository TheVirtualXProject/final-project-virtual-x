package com.thevirtualx.mvcApp.Storage;
import com.thevirtualx.mvcApp.Entity.Comment;
import com.thevirtualx.mvcApp.Repo.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentStorage {
    private CommentRepository commentRepo;
    public CommentStorage (CommentRepository commentRepo){
        this.commentRepo = commentRepo;
    }
    public Comment retrieveCommentById(Long id) { return commentRepo.findById(id).get();}
    public void addComment(Comment commentToAdd) {commentRepo.save(commentToAdd);}
    public void deleteCommentById(Long id) {commentRepo.deleteById(id);}
}
