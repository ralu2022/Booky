/*
 * Class that contains all the unit testing method to test the main add function of the User class.
 *
 * */


package com.booky.homelibrary;

import com.booky.homelibrary.model.User;
import com.booky.homelibrary.repository.JdbcUserRepository;
import org.junit.Test;

import java.sql.SQLException;

public class UserTest extends JdbcUserRepository {

    @Test
    public void addUserTest() throws SQLException, ClassNotFoundException {
        String user_name = "park";
        String password = "national";

        User user = new User(user_name, password);

        JdbcUserRepository userRepo = new JdbcUserRepository();

        userRepo.addUser(user);
    }

    @Test
    public void userLoginTest() throws SQLException, ClassNotFoundException {

        String user_name = "park";
        String password = "national";

        User user = new User(user_name, password);

        JdbcUserRepository userRepo = new JdbcUserRepository();

        userRepo.userLogin(user);

    }

}
