<%@ page import="com.booky.homelibrary.model.Author" %>
<%@ page import="com.booky.homelibrary.repository.JdbcAuthorRepository" %>


<%

    String authorName = request.getParameter("author_name");
    JdbcAuthorRepository authorRepo = new JdbcAuthorRepository();

    authorRepo.deleteAuthor(authorName);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/authorallhtml.jsp"/>