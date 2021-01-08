package by.dzen.dao;

import by.dzen.connection.HikariCPDataSource;
import by.dzen.entity.Like;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LikeDaoImpl implements LikeDao {

    private HikariCPDataSource hikariCPDataSource;

    public LikeDaoImpl(HikariCPDataSource hikariCPDataSource) {
        this.hikariCPDataSource = hikariCPDataSource;
    }

    @Override
    public void insertLikePost(Like like) {
        try {
            String sql = "INSERT INTO likes VALUES (default , ?,?)";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, like.getUserId());
            ps.setLong(2, like.getPostId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Like> getLikeListFromDB() {
        List<Like> likes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM likes";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long idLike = rs.getLong("id");
                long idUser = rs.getLong("users_test_id");
                long idPost = rs.getLong("posts_id");
                likes.add(new Like(idLike, idUser, idPost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }
}
