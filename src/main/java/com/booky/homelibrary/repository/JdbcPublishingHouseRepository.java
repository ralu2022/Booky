/*
 *  The class is used to connect to the database and extract data related to publishing houses.
 *  It also contains all the CRUD methods plus a count method, created based on the columns existing in the publishing houses table:

 * */


package com.booky.homelibrary.repository;


import com.booky.homelibrary.model.PublishingHouse;

import javax.swing.*;
import java.sql.*;

import java.util.*;

public class JdbcPublishingHouseRepository {
    public JdbcPublishingHouseRepository() {

        getConnection();
    }

    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/bookydb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "4891";

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Can't connect to the db" + e.getMessage());
        }
    }

    public List<PublishingHouse> getAllPublishingHouses() {
        List<PublishingHouse> publishingHouses = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM publishing_house ORDER BY publishing_house_name")) {

            while (resultSet.next()) {
                int publishing_house_id = resultSet.getInt("publishing_house_id");
                String publishing_house_name = resultSet.getString("publishing_house_name");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");
                String country = resultSet.getString("country");

                PublishingHouse publishingHouse = new PublishingHouse(publishing_house_id, publishing_house_name, city, address, country);

                publishingHouse.setPublishing_house_id(publishing_house_id);
                publishingHouse.setPublishing_house_name(publishing_house_name);
                publishingHouse.setCity(city);
                publishingHouse.setAddress(address);
                publishingHouse.setCountry(country);

                publishingHouses.add(publishingHouse);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishingHouses;

    }

    public void addPublishingHouse(PublishingHouse publishingHouse) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM publishing_house WHERE publishing_house_name=?")) {

            statement.setString(1, publishingHouse.getPublishing_house_name());

            ResultSet resultSet = statement.executeQuery();

            int counter = 0;

            while (resultSet.next()) {
                counter++;
            }

            if (counter > 0) {
                JOptionPane.showMessageDialog(null, "Publishing house already added!");

            } else {
                try (Connection connection1 = getConnection();
                     PreparedStatement statement1 = connection.prepareStatement("INSERT INTO publishing_house (publishing_house_name,city,address,country ) VALUES (?, ?, ?, ?)")) {

                    statement1.setString(1, publishingHouse.getPublishing_house_name());
                    statement1.setString(2, publishingHouse.getCity());
                    statement1.setString(3, publishingHouse.getAddress());
                    statement1.setString(4, publishingHouse.getCountry());

                    statement1.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updatePublishingHouse(PublishingHouse publishingHouse) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE publishing_house SET city=?, address=?, country=? WHERE publishing_house_name=?")) {

            statement.setString(1, publishingHouse.getCity());
            statement.setString(2, publishingHouse.getAddress());
            statement.setString(3, publishingHouse.getCountry());
            statement.setString(4, publishingHouse.getPublishing_house_name());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePublishingHouse(String publishingHouseName) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM publishing_house WHERE publishing_house_name=?")) {

            statement.setString(1, publishingHouseName);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PublishingHouse> getAllPublishingHousesByCity() {
        List<PublishingHouse> publishingHouses = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT publishing_house.city, COUNT(publishing_house.city) AS city_count " +
                     "FROM publishing_house " +
                     "GROUP BY city")) {

            while (resultSet.next()) {
                String city = resultSet.getString("city");
                int city_count = resultSet.getInt("city_count");
                PublishingHouse publishingHouse = new PublishingHouse(city, city_count);
                publishingHouse.setCity(city);
                publishingHouse.setCity_count(city_count);
                publishingHouses.add(publishingHouse);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publishingHouses;
    }

}




