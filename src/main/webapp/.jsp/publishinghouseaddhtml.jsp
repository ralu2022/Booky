<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>

<%@ page import="com.booky.homelibrary.model.PublishingHouse" %>
<%@ page import="com.booky.homelibrary.repository.JdbcPublishingHouseRepository" %>

<html>

<head>
  <style>
    body {
      background-image: url("books.jpg");
    }
    label {
      display: inline-block;
      width: 150px;
      text-align: right;
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
    <a class="nav-link active" href="publishinghouseallhtml.jsp">LIST</a>
  </li>
</ul>
</br>
<div align="CENTER" class="form-outline mb-4">
  <img src="book11.jpg" height="300" width="600">
  <br>
  <br>
  <br>
  <h2  style="color: coral" align="CENTER"><strong>CREATE PUBLISHING HOUSE</strong></h2>
  </br>
  </br>
  <form action="publishinghouseadd.jsp">
    <div align="CENTER" class="form-outline mb-4">
      <%--@declare id="inputbook"--%><label style="color:cadetblue" for="inputBook"><strong>PUBLISHING HOUSE NAME</strong></label>
      <input type="text" size="50" name="publishing_house_name" value!="null" onclick="this.value=''" required="true"/><br/>
    </div>
    <br/>
    <div align="CENTER" class="form-outline mb-4">
      <%--@declare id="inputbook"--%><label style="color:cadetblue" for="inputBook"><strong>ADDRESS</strong></label>
      <input type="text" size = "50" name="address" value!="null" onclick="this.value=''" required="true"/><br/>
    </div>
    <div align="CENTER" class="form-outline mb-4">
      <label style="color:cadetblue" for="inputBook"><strong>CITY</strong></label>
      <input type="text" name="city" value!="null" onclick="this.value=''" required="true"/><br/>
    </div>
    <div align="CENTER" class="form-outline mb-4">
      <label style="color:cadetblue"   for="inputBook"><strong>COUNTRY</strong></label>
      <input type="text"    name="country" value!="null" onclick="this.value=''" required="true"/><br/>
    </div>
    <br>
    <div align="CENTER" class="form-outline mb-4">
      <input class="btn btn-primary" type="submit" value="Submit">
    </div>
  </form>
</div>
</form>

</body>
</html>
