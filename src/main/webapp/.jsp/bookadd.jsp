<%@ page import="com.booky.homelibrary.model.Book" %>
<%@ page import="com.booky.homelibrary.repository.JdbcBookRepository" %>



<%
    String book_title = request.getParameter("book_title");
    String book_review = request.getParameter("book_review");
    String isbn_code = request.getParameter("isbn_code");
    String author_id = request.getParameter("author_id");
    String publishing_house_id = request.getParameter("publishing_house_id");
    int id_author = Integer.parseInt(author_id);
    int id_publishing_house = Integer.parseInt(publishing_house_id);


    Book book = new Book (book_title,book_review,isbn_code,id_author,id_publishing_house);
    JdbcBookRepository bookRepo = new JdbcBookRepository();
    bookRepo.addBook(book);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/bookallhtml.jsp"/>