<%@ page import="com.booky.homelibrary.model.PublishingHouse" %>
<%@ page import="com.booky.homelibrary.repository.JdbcPublishingHouseRepository"%>
<%@ page import="com.booky.homelibrary.repository.JdbcAuthorRepository" %>


<%

  String publishingHouseName = request.getParameter("publishing_house_name");
  String city = request.getParameter("city");
  String address = request.getParameter("address");
  String country =request.getParameter("country");

  PublishingHouse publishingHouse = new PublishingHouse(publishingHouseName,city,address,country);

  JdbcPublishingHouseRepository publishingHouseRepo = new JdbcPublishingHouseRepository();

  publishingHouseRepo.updatePublishingHouse(publishingHouse);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/publishinghouseallhtml.jsp" />