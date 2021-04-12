package com.thevirtualx.mvcApp.Repo;
import com.thevirtualx.mvcApp.Entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository <Comment, Long> {
}
