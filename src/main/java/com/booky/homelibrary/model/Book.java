/*
 * Base class for books that contains all the necessary fields used for database CRUD methods.
 * */


package com.booky.homelibrary.model;

import lombok.Data;

@Data
public class Book {
    private int author_count;
    private int book_id;
    private String book_title;
    private String book_review;
    private String isbn_code;
    private String author_name;
    private String publishing_house_name;
    private int author_id;
    private int publishing_house_id;


    public Book(int book_id, String book_title, String book_review, String isbn_code, int author_id, int publishing_house_id) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_review = book_review;
        this.isbn_code = isbn_code;
        this.author_id = author_id;
        this.publishing_house_id = publishing_house_id;
    }

    public Book(String book_title, String book_review, String isbn_code, int author_id, int publishing_house_id) {
        this.book_title = book_title;
        this.book_review = book_review;
        this.isbn_code = isbn_code;
        this.author_id = author_id;
        this.publishing_house_id = publishing_house_id;
    }

    public Book(String book_title, String book_review, String isbn_code, String author_name, String publishing_house_name) {
        this.book_title = book_title;
        this.book_review = book_review;
        this.isbn_code = isbn_code;
        this.author_name = author_name;
        this.publishing_house_name = publishing_house_name;

    }

    public Book(int book_id, String book_title, String book_review, String isbn_code, String author_name, String publishing_house_name) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_review = book_review;
        this.isbn_code = isbn_code;
        this.author_name = author_name;
        this.publishing_house_name = publishing_house_name;

    }

    public Book(String bookTitle, String bookReview, String isbnCode) {
        this.book_title = bookTitle;
        this.book_review = bookReview;
        this.isbn_code = isbnCode;
    }

    public Book(String authorName) {
        this.author_name = authorName;
    }

    public Book(String authorName, int authorCount) {
        this.author_name = authorName;
        this.author_count = authorCount;

    }
}

