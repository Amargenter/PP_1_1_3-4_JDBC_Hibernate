package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id INT not NULL AUTO_INCREMENT, name VARCHAR(45), " +
                " lastName VARCHAR(45), age TINYINT(3), " +
                " PRIMARY KEY (id))";
        statementCalling(sql);
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS `users`";
        statementCalling(sql);
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = String.format("INSERT INTO users (name, lastName, age)" +
                " VALUES ('%s', '%s', %d)", name, lastName, age);
        statementCalling(sql);
    }

    public void removeUserById(long id) {
        String sql = String.format("DELETE FROM users WHERE id = %d", id);
        statementCalling(sql);
    }

    public List<User> getAllUsers() {

        List<User> usersList = new ArrayList<>();

        String sql = "SELECT * FROM users";
        try (Statement statement = Util.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE users";
        statementCalling(sql);
    }

    public void statementCalling(String sql) {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
