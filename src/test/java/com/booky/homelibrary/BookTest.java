/*
 * Class that contains all the unit testing method to test the main CRUD functions of the Book class.
 *
 * */

package com.booky.homelibrary;

import com.booky.homelibrary.model.Book;
import com.booky.homelibrary.repository.JdbcBookRepository;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;

public class BookTest extends JdbcBookRepository {
    private JdbcBookRepository bookTest = new JdbcBookRepository();

    @Test
    public void allAuthorsTest() throws SQLException, ClassNotFoundException {
        List<Book> books = bookTest.getAllBooks();

        books.forEach(System.out::println);
    }

    @Test
    public void addBookTest() throws SQLException, ClassNotFoundException {
        String book_title = "Un barbat pe nume Ove";
        String book_review = "Excellent";
        String isbn_code = "4777-658-45";
        String author_id = "14";
        String publishing_house_id = "74";
        int id_author = Integer.parseInt(author_id);
        int id_publishing_house = Integer.parseInt(publishing_house_id);


        Book book = new Book(book_title, book_review, isbn_code, id_author, id_publishing_house);
        JdbcBookRepository bookRepo = new JdbcBookRepository();
        bookRepo.addBook(book);
    }

    @Test
    public void updateBookTest() throws SQLException, ClassNotFoundException {
        String book_title = "Un barbat pe nume Ove";
        String book_review = "So and so";
        String isbn_code = "154-88-369";

        Book book = new Book(book_title, book_review, isbn_code);
        JdbcBookRepository bookRepo = new JdbcBookRepository();

        bookRepo.updateBook(book);
    }

    @Test
    public void deleteBookTest() throws SQLException, ClassNotFoundException {
        String isbn_code = "154-88-369";
        JdbcBookRepository bookRepo = new JdbcBookRepository();

        bookRepo.deleteBook(isbn_code);
    }

    @Test
    public void countBookTest() throws SQLException, ClassNotFoundException {

        bookTest.getAllBooksCountByAuthorName();

    }
}
