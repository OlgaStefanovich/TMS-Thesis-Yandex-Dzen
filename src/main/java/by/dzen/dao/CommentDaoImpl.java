package by.dzen.dao;

//import by.realovka.ConnectionPool;

import by.dzen.connection.HikariCPDataSource;
import by.dzen.entity.Comment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    private HikariCPDataSource connectionPool;

    public CommentDaoImpl(HikariCPDataSource connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void createComment(Comment comment) {
        try {
            String sql = "INSERT INTO comments VALUES (default, ?,?,?,?)";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, comment.getText());
            ps.setLong(2, comment.getUserId());
            ps.setLong(3, comment.getPostId());
            ps.setDate(4, comment.getDate());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getListCommentsFromDB() {
        List<Comment> comments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comments ";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String text = resultSet.getString("text");
                long userId = resultSet.getLong("users_test_id");
                long postsId = resultSet.getLong("posts_id");
                Date date = resultSet.getDate("created_at");
                comments.add(new Comment(text, userId, postsId, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
