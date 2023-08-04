<%@ page import="com.booky.homelibrary.model.Book" %>
<%@ page import="com.booky.homelibrary.repository.JdbcBookRepository"%>


<%

  String book_title = request.getParameter("book_title");
  String book_review = request.getParameter("book_review");
  String isbn_code = request.getParameter("isbn_code");



  Book book = new Book (book_title,book_review,isbn_code);
  JdbcBookRepository bookRepo = new JdbcBookRepository();

  bookRepo.updateBook(book);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/bookallhtml.jsp" />