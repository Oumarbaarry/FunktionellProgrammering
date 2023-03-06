package Inlämningsuppgift2;

import java.sql.*;

interface ConnectDB{
    void connect();
}

interface CloseDB{
    void close();
}

interface ExecuteQuery{
    ResultSet execute(String query);
}

public class DBConnection {
    String username, password;
    Connection connection;

    DBConnection(String username, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.username = username;
            this.password = password;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ConnectDB connectDB = () -> {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbshop",username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    };

    CloseDB closeDB = () -> {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    };

    ExecuteQuery executeQuery = (String query) -> { 
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    };
}




