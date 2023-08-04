/*
 *  The class is used to connect to the database and extract data related to authors.
 *  It also contains all the CRUD methods plus a count method, created based on the columns existing in the authors table:

 * */

package com.booky.homelibrary.repository;

import com.booky.homelibrary.model.Author;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcAuthorRepository {

    public JdbcAuthorRepository() {

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

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM authors ORDER BY author_name")) {

            while (resultSet.next()) {
                int author_id = resultSet.getInt("author_id");
                String author_name = resultSet.getString("author_name");
                String author_nationality = resultSet.getString("author_nationality");
                String date_of_birth = resultSet.getString("date_of_birth");
                String written_books = resultSet.getString("written_books");

                Author author = new Author(author_id, author_name, author_nationality, date_of_birth, written_books);

                author.setAuthor_id(author_id);
                author.setAuthor_name(author_name);
                author.setAuthor_nationality(author_nationality);
                author.setDate_of_birth(date_of_birth);
                author.setWritten_books(written_books);

                authors.add(author);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;

    }

    public void addAuthor(Author author) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM authors WHERE author_name=?")) {

            statement.setString(1, author.getAuthor_name());

            ResultSet resultSet = statement.executeQuery();

            int counter = 0;

            while (resultSet.next()) {
                counter++;
            }

            if (counter > 0) {
                JOptionPane.showMessageDialog(null, "Author already added!");

            } else

                try (Connection connection1 = getConnection();
                     PreparedStatement statement1 = connection.prepareStatement("INSERT INTO authors(author_name,author_nationality,date_of_birth,written_books) VALUES(?,?,?,?)")) {

                    statement1.setString(1, author.getAuthor_name());
                    statement1.setString(2, author.getAuthor_nationality());
                    statement1.setString(3, author.getDate_of_birth());
                    statement1.setString(4, author.getWritten_books());

                    statement1.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAuthor(Author author) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE authors SET author_nationality=?, date_of_birth=?, written_books=? WHERE author_name=?")) {


            statement.setString(1, author.getAuthor_nationality());
            statement.setString(2, author.getDate_of_birth());
            statement.setString(3, author.getWritten_books());
            statement.setString(4, author.getAuthor_name());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(String authorName) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM authors WHERE author_name=?")) {

            statement.setString(1, authorName);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAllAuthorsByNationality() {
        List<Author> authors = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT authors.author_nationality, COUNT(authors.author_nationality) AS nationality_count " +
                     "FROM authors " +
                     "GROUP BY author_nationality")) {


            while (resultSet.next()) {
                String author_nationality = resultSet.getString("author_nationality");
                int nationality_count = resultSet.getInt("nationality_count");
                Author author = new Author(author_nationality, nationality_count);
                author.setAuthor_nationality(author_nationality);
                author.setNationality_count(nationality_count);
                authors.add(author);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

}









