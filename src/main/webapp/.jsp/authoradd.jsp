<%@ page import="com.booky.homelibrary.model.Author" %>
<%@ page import="com.booky.homelibrary.repository.JdbcAuthorRepository" %>



<%
  String author_name = request.getParameter("author_name");
  String author_nationality = request.getParameter("author_nationality");
  String date_of_birth = request.getParameter("date_of_birth");
  String written_books = request.getParameter("written_books");

  Author author = new Author(author_name,author_nationality,date_of_birth,written_books);

  JdbcAuthorRepository authorRepo = new JdbcAuthorRepository();

  authorRepo.addAuthor(author);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/authorallhtml.jsp"/>