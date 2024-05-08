/*
 * Base class for authors that contains all the necessary fields used for database CRUD methods.
 * */


package com.booky.homelibrary.model;

import lombok.Data;


@Data
public class Author {

    private int nationality_count;
    private int author_id;
    private String author_name;
    private String author_nationality;
    private String date_of_birth;
    private String written_books;

    public Author(int author_id, String author_name, String author_nationality, String date_of_birth, String written_books) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_nationality = author_nationality;
        this.date_of_birth = date_of_birth;
        this.written_books = written_books;
    }

    public Author(String author_name, String author_nationality, String date_of_birth, String written_books) {
        this.author_name = author_name;
        this.author_nationality = author_nationality;
        this.date_of_birth = date_of_birth;
        this.written_books = written_books;
    }

    public Author(String author_name) {
        this.author_name = author_name;
    }

    public Author(String authorName, int nationalityCount) {
        this.author_name = authorName;
        this.nationality_count = nationalityCount;
    }
}
