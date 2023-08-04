/*
 * Base class for publishing houses that contains all the necessary fields used for database CRUD methods.
 * */


package com.booky.homelibrary.model;

import lombok.Data;

@Data
public class PublishingHouse {
    private int city_count;
    private int publishing_house_id;
    private String publishing_house_name;
    private String city;
    private String address;
    private String country;

    public PublishingHouse(int publishing_house_id, String publishing_house_name, String city, String address, String country) {
        this.publishing_house_id = publishing_house_id;
        this.publishing_house_name = publishing_house_name;
        this.city = city;
        this.address = address;
        this.country = country;
    }

    public PublishingHouse(String publishing_house_name, String city, String address, String country) {
        this.publishing_house_name = publishing_house_name;
        this.city = city;
        this.address = address;
        this.country = country;
    }

    public PublishingHouse(String publishing_house_name) {
        this.publishing_house_name = publishing_house_name;

    }

    public PublishingHouse(String city, int city_count) {
        this.city = city;
        this.city_count = city_count;
    }
}
