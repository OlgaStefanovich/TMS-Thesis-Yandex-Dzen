package by.dzen.dao;

//import by.realovka.ConnectionPool;

import by.dzen.connection.HikariCPDataSource;
import by.dzen.entity.Post;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PostDaoImpl implements PostDao {

    private HikariCPDataSource hikariCPDataSource;

    public PostDaoImpl(HikariCPDataSource hikariCPDataSource) {
        this.hikariCPDataSource = hikariCPDataSource;
    }

    @Override
    public void createPost(Post post, long id) {
        try {
            String sql = "INSERT INTO posts VALUES (default, ?,?,?,?,default, ?)";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getText());
            ps.setTimestamp(4, post.getTimestamp());
            ps.setLong(5, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getListPostsToFirstPage() {
        List<Post> posts = new ArrayList<>();
        Post postFromDB = new Post();
        try {
            String sql = "SELECT * FROM posts ORDER BY created_at DESC";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("text");
                Timestamp timestamp = resultSet.getTimestamp("created_at");
                postFromDB = new Post(id, title, text, timestamp);
                posts.add(postFromDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post getPostToPage(long id) {
        Post postViewOnPage = new Post();
        try {
            String sql = "SELECT * FROM posts WHERE id=?";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                postViewOnPage = new Post(rs.getLong("id"), rs.getString("title"), rs.getString("text"), rs.getLong("views"), rs.getTimestamp("created_at"), rs.getInt("users_test_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postViewOnPage;
    }

    @Override
    public void insertViewPost(long id) {
        String sql = null;
        try {
                sql = "UPDATE posts SET views=views+1 WHERE id=?";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

