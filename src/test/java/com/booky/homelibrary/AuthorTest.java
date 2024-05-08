/*
 * Class that contains all the unit testing method to test the main CRUD functions of the Author class.
 *
 * */


package com.booky.homelibrary;

import com.booky.homelibrary.model.Author;
import com.booky.homelibrary.repository.JdbcAuthorRepository;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;


public class AuthorTest extends JdbcAuthorRepository {
    private JdbcAuthorRepository authorTest = new JdbcAuthorRepository();

    @Test
    public void allAuthorsTest() throws SQLException, ClassNotFoundException {
        List<Author> authors = authorTest.getAllAuthors();

        authors.forEach(System.out::println);
    }

    @Test
    public void addAuthorTest() throws SQLException, ClassNotFoundException {
        String author_name = "Frederick Backmann";
        String author_nationality = "hungarian";
        String date_of_birth = "25-04-1784";
        String written_books = "Brit Marie, Bunica mi-a spus sa iti spun ca ii pare rau";

        Author author1 = new Author(author_name, author_nationality, date_of_birth, written_books);

        JdbcAuthorRepository authorRepo = new JdbcAuthorRepository();

        authorRepo.addAuthor(author1);
    }

    @Test
    public void updateAuthorTest() throws SQLException, ClassNotFoundException {

        String author_name = "Frederick Backmann";
        String author_nationality = "hungarian";
        String date_of_birth = "05-01-1991";
        String written_books = "Bunica mi-a spus sa iti spun ca ii pare rau";

        Author author = new Author(author_name, author_nationality, date_of_birth, written_books);

        JdbcAuthorRepository authorRepo = new JdbcAuthorRepository();

        authorRepo.updateAuthor(author);
    }

    @Test
    public void deleteAuthorTest() throws SQLException, ClassNotFoundException {
        String authorName = "Frederick Backmann";
        JdbcAuthorRepository authorRepo = new JdbcAuthorRepository();

        authorRepo.deleteAuthor(authorName);
    }

    @Test
    public void countAuthorTest() throws SQLException, ClassNotFoundException {

        authorTest.getAllAuthorsByNationality();

    }

}
