<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>


<%@ page import="com.booky.homelibrary.repository.JdbcPublishingHouseRepository" %>
<%@ page import="com.booky.homelibrary.model.PublishingHouse" %>

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
        <a class="nav-link active" href="publishinghouseaddhtml.jsp">ADD</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="publishingHouseUpdateHtml.jsp">UPDATE</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="publishinghousedeletehtml.jsp">DELETE</a>
    </li>
</ul>
</br>
<div align="CENTER">
    <img src="book14.jpg" height="300" width="600">
    <br>
    <br>
    <br>
    <h2 style="color: coral"><strong>PUBLISHING HOUSE LIST</strong></h2>
    <br>
    <br>
    <table align="CENTER" border="1" class="table table-striped table-hover w-50 p-3">
        <tr>
            <th>ID</th>
            <th>PUBLISHING HOUSE NAME</th>
            <th>CITY</th>
            <th>ADDRESS</th>
            <th>COUNTRY</th>
        </tr>

        <%
            JdbcPublishingHouseRepository repository = new JdbcPublishingHouseRepository();
            List<PublishingHouse> publishingHouses = repository.getAllPublishingHouses();
            for (PublishingHouse publishingHouse : publishingHouses) {
        %>
        <tr>
            <td><%= publishingHouse.getPublishing_house_id()%>
            </td>
            <td><%= publishingHouse.getPublishing_house_name() %>
            </td>
            <td><%= publishingHouse.getCity() %>
            </td>
            <td><%= publishingHouse.getAddress() %>
            </td>
            <td><%= publishingHouse.getCountry() %>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
<br/>
<br/>
