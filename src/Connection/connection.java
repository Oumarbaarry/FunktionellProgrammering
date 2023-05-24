package Connection;

import java.sql.*;

public class connection {


    public static void main(String[] args) throws ClassNotFoundException{



        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Webbshop?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true",
                "****", "*********");
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery("select id, namn, personnummer from kund")
        ){

            while (rs.next()){
                int id = rs.getInt("id");
                String personnummer = rs.getString("personnummer");
                String namn = rs.getString("namn");

                System.out.println(id+" "+namn+" "+personnummer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
