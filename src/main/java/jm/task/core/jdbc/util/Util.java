package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД

    //private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // If using Java > 5, this line is not needed.
            //Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так.");
            e.printStackTrace();
        }
        return connection;
    }
}
