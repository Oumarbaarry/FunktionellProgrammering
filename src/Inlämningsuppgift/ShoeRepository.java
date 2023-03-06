package Inlämningsuppgift;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoeRepository {
    public static List<Shoe> getAllShoes() throws SQLException, IOException {
        List<Shoe> shoes = new ArrayList<>();
        DBConnection dbConnection = DBConnection.getInstance();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select id,size,brand,color,price,quantity from Webbshop.Skor")

        ) {
            while (resultSet.next()) {
                Shoe temp = new Shoe();
                int id = resultSet.getInt("id");
                temp.setId(id);

                String size = resultSet.getString("storlek");
                temp.setSize(size);

                String brand = resultSet.getString("märke");
                temp.setBrand(brand);

                String color = resultSet.getString("färg");
                temp.setColor(color);

                int price = resultSet.getInt("pris");
                temp.setPrice(price);

                int quantity = resultSet.getInt("innehåller");
                temp.setQuantity(quantity);

                shoes.add(temp);
            }
        }
        return shoes;
    }
    public static List<Shoe> getAllShoesByCategory(String category) throws SQLException, IOException {
        List<Shoe> shoes = new ArrayList<>();
        String query = "select Skor.id, Skor.storlek, Skor.märke, Skor.färg, Skor.pris, Skor.innehåller from Skor " +
                "inner join Kategorimapp on Skor.id = Kategorimapp.Skor.id " +
                "inner join Kategori on Kategorimapp.KId = shoeCategory.id" +
                " where shoeCategory.typeOfShoe = ?";
        DBConnection dbConnection = DBConnection.getInstance();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                shoes.add(new Shoe(rs.getInt("id"),rs.getString("storlek"),
                        rs.getString("märke"), rs.getString("färg"),
                        rs.getInt("pris"), rs.getInt("innehåller")));
            }
        }
        return shoes;
    }

    public static Customer getCustomerByLogin(String name, String password) throws SQLException, IOException {
        String query = "select Kund.id, Kund.firstName, Kund.lastName " +
                "from Kund where Kund.firstName = ?" +
                " and Kund.passwords = ?";
        DBConnection dbConnection = DBConnection.getInstance();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1,name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Customer(rs.getInt("id"), rs.getString("firstName"),
                        rs.getString("lastName"));
            }
        }
        return null;
    }
}