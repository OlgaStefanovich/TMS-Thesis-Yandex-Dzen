package by.dzen.service;

import by.dzen.dao.CommentDaoImpl;
import by.dzen.dao.UserDaoImpl;
import by.dzen.dto.comment.CommentDTO;
import by.dzen.entity.Comment;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentDaoImpl commentDao;
    private UserDaoImpl userDao;

    public CommentService(CommentDaoImpl commentDao, UserDaoImpl userDao) {
        this.commentDao = commentDao;
        this.userDao = userDao;
    }

    public void addComment(CommentDTO commentDTO, long postId, long userId) {
        Comment comment = new Comment(commentDTO.getText(), userId, postId, Date.valueOf(LocalDate.now()));
        commentDao.createComment(comment);
    }

    public List<CommentDTO> getListCommentsToPostOnPage(long postId) {
        List<Comment> comments = commentDao.getListCommentsFromDB();
        List<CommentDTO> commentToPostOnPage = new ArrayList<>();
        String nameUserWHoWriteComment = null;
        for (Comment item : comments) {
            if (item.getPostId() == postId) {
                if (userDao.findById(item.getUserId()).isPresent()) {
                    nameUserWHoWriteComment = userDao.findById(item.getUserId()).get().getName();
                }
             CommentDTO commentDTO = new CommentDTO(item.getText(),item.getDate(),nameUserWHoWriteComment);
             commentToPostOnPage.add(commentDTO);
            }
        }
        return commentToPostOnPage;
    }
}
