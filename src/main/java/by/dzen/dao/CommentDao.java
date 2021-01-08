package by.dzen.dao;

import by.dzen.entity.Comment;

import java.util.List;

public interface CommentDao {

     void createComment(Comment comment);
     List<Comment> getListCommentsFromDB();
}
