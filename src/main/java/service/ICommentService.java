package service;

import model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(int id);
    void save(Comment comment);
    void update(Comment comment);
    void delete(int id);
}
