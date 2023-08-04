<%@ page import="com.booky.homelibrary.model.Book" %>
<%@ page import="com.booky.homelibrary.repository.JdbcBookRepository" %>


<%

    String isbn_code = request.getParameter("isbn_code");
    JdbcBookRepository bookRepo = new JdbcBookRepository();

    bookRepo.deleteBook(isbn_code);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/bookallhtml.jsp" />