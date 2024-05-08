<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>

<%@ page import="com.booky.homelibrary.model.Book" %>
<%@ page import="com.booky.homelibrary.repository.JdbcBookRepository" %>
<%@ page import="com.booky.homelibrary.repository.JdbcAuthorRepository" %>
<%@ page import="com.booky.homelibrary.model.Author" %>

<head>
    <style>
        body {
            background-image: url("books.jpg");
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Booky</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" style="background-color: burlywood" href="amainpage.jsp"><strong>HOME</strong></a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="bookallhtml.jsp">LIST</a>
    </li>
</ul>
</br>

<div align="CENTER">
    <img src="book10.jpg" height="300" width="600">
    <br>
    <br>
    <br>
    <h2 style="color: coral"><strong>AUTHOR COUNT BY NATIONALITY</strong></h2>
    <br>
    <br>
    <table align="CENTER" border="1" class="table table-striped table-hover w-50 p-3">
        <tr>
            <th>NATIONALITY</th>
            <th>COUNT</th>
        </tr>
        <%
            JdbcAuthorRepository repository = new JdbcAuthorRepository();
            List<Author> authors = repository.getAllAuthorsByNationality();
            for (Author author : authors) {
        %>
        <tr>
            <td><%= author.getAuthor_nationality()%>
            </td>
            <td><%= author.getNationality_count()%>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
<br/>
<br/>
