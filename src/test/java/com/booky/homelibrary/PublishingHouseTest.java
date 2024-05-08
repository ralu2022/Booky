/*
 * Class that contains all the unit testing method to test the main CRUD functions of the Publishing House class.
 *
 * */


package com.booky.homelibrary;


import com.booky.homelibrary.model.PublishingHouse;
import com.booky.homelibrary.repository.JdbcPublishingHouseRepository;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class PublishingHouseTest extends JdbcPublishingHouseRepository {
    private JdbcPublishingHouseRepository publishingHouseTest = new JdbcPublishingHouseRepository();

    @Test
    public void allPublishingHouses() throws SQLException, ClassNotFoundException {
        List<PublishingHouse> publishingHouses = publishingHouseTest.getAllPublishingHouses();

        publishingHouses.forEach(System.out::println);
    }

    @Test
    public void addPublishingHouse() throws SQLException, ClassNotFoundException {
        String publishing_house_name = "Dante International";
        String city = "Calarasi";
        String address = "Mercurului 20D bl 8 sc A";
        String country = "Romania";

        PublishingHouse publishingHouse = new PublishingHouse(publishing_house_name, city, address, country);

        JdbcPublishingHouseRepository publishingHouseRepo = new JdbcPublishingHouseRepository();

        publishingHouseRepo.addPublishingHouse(publishingHouse);
    }

    @Test
    public void updatePublishingHouse() throws SQLException, ClassNotFoundException {
        String publishingHouseName = "Dante International";
        String city = "Tulcea";
        String address = "Mercurului 20D bl 8 sc A";
        String country = "Romania";

        PublishingHouse publishingHouse = new PublishingHouse(publishingHouseName, city, address, country);

        JdbcPublishingHouseRepository publishingHouseRepo = new JdbcPublishingHouseRepository();

        publishingHouseRepo.updatePublishingHouse(publishingHouse);
    }

    @Test
    public void deletePublishingHouse() throws SQLException, ClassNotFoundException {
        String publishingHouseName = "Dante International";
        JdbcPublishingHouseRepository publishingHouseRepo = new JdbcPublishingHouseRepository();


        publishingHouseRepo.deletePublishingHouse(publishingHouseName);
    }

    @Test
    public void addAuthorTest() throws SQLException, ClassNotFoundException {

        publishingHouseTest.getAllPublishingHousesByCity();
    }

}
