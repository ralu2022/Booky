/*
 *  The class is used to connect to the database and extract data related to books.
 *  It also contains all the CRUD methods plus a count method, created based on the columns existing in the books table:

 * */


package com.booky.homelibrary.repository;

import com.booky.homelibrary.model.Book;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookRepository {
    public JdbcBookRepository() {

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

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT books.book_id, books.book_title, authors.author_name, publishing_house.publishing_house_name, books.book_review, books.isbn_code " +
                     "FROM books " +
                     "JOIN authors ON books.author_id = authors.author_id " +
                     "JOIN publishing_house ON books.publishing_house_id = publishing_house.publishing_house_id " +
                     "ORDER BY isbn_code")) {

            while (resultSet.next()) {

                int book_id = resultSet.getInt("book_id");
                String book_title = resultSet.getString("book_title");
                String book_review = resultSet.getString("book_review");
                String isbn_code = resultSet.getString("isbn_code");
                String author_name = resultSet.getString("author_name");
                String publishing_house_name = resultSet.getString("publishing_house_name");


                Book book = new Book(book_id, book_title, book_review, isbn_code, author_name, publishing_house_name);

                book.setBook_id(book_id);
                book.setBook_title(book_title);
                book.setBook_review(book_review);
                book.setIsbn_code(isbn_code);
                book.setAuthor_name(author_name);
                book.setPublishing_house_name(publishing_house_name);


                books.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void addBook(Book book) {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE isbn_code=?")) {

            statement.setString(1, book.getIsbn_code());

            ResultSet resultSet = statement.executeQuery();

            int counter = 0;

            while (resultSet.next()) {
                counter++;
            }

            if (counter > 0) {
                JOptionPane.showMessageDialog(null, "Book already added!");

            } else {
                try (Connection connectionInsert = getConnection();
                     PreparedStatement statementInsert = connectionInsert.prepareStatement("INSERT INTO books (book_title, book_review, isbn_code, author_id, publishing_house_id) VALUES (?,?,?,?,?)")) {

                    statementInsert.setString(1, book.getBook_title());
                    statementInsert.setString(2, book.getBook_review());
                    statementInsert.setString(3, book.getIsbn_code());
                    statementInsert.setInt(4, book.getAuthor_id());
                    statementInsert.setInt(5, book.getPublishing_house_id());

                    statementInsert.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateBook(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE books SET book_title=?, isbn_code=?, book_review=? WHERE isbn_code=?")) {


            statement.setString(1, book.getBook_title());
            statement.setString(2, book.getIsbn_code());
            statement.setString(3, book.getBook_review());
            statement.setString(4, book.getIsbn_code());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String isbn_code) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE isbn_code=?")) {

            statement.setString(1, isbn_code);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooksCountByAuthorName() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT authors.author_name, COUNT(authors.author_name) AS book_count " +
                     "FROM books " +
                     "JOIN authors ON books.author_id = authors.author_id " +
                     "GROUP BY author_name")) {


            while (resultSet.next()) {
                String author_name = resultSet.getString("author_name");
                int author_count = resultSet.getInt("book_count");
                Book book = new Book(author_name, author_count);
                book.setAuthor_name(author_name);
                book.setAuthor_count(author_count);
                books.add(book);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}










