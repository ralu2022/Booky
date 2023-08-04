/*
 * Main class that supports the JDBCUser class for adding a new username and checking if the username is in the databae.
 * */


package com.booky.homelibrary.model;

import lombok.Data;

@Data
public class User {

    private int user_id;
    private String user_name;
    private String password;

    public User(String user_name, String password) {

        this.user_name = user_name;
        this.password = password;

    }
}
