package by.dzen.dao;

//import by.realovka.ConnectionPool;

import by.dzen.connection.HikariCPDataSource;
import by.dzen.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


@Repository
public class UserDaoImpl implements UserDao{

    private  HikariCPDataSource hikariCPDataSource;

    public UserDaoImpl(HikariCPDataSource hikariCPDataSource) {
        this.hikariCPDataSource = hikariCPDataSource;
    }

    @Override
    public void createUser(User user) {
        try {
            String sql = "INSERT INTO users_test VALUES (default , ?,?,?)";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> containsByLogin(String login) {
        try {
            String sql = "SELECT * FROM users_test WHERE login=?";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getString("login")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> containsUser(User user) {
        try {
            String sql = "SELECT * FROM users_test WHERE login=? AND password=?";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getLong("id"), rs.getString("name"), rs.getString("login"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(long id) {
        try {
            String sql = "SELECT * FROM users_test WHERE id=?";
            Connection connection = HikariCPDataSource.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getLong("id"), rs.getString("name"), rs.getString("login"), rs.getString("password")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
