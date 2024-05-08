<%@ page import="com.booky.homelibrary.model.PublishingHouse" %>
<%@ page import="com.booky.homelibrary.repository.JdbcPublishingHouseRepository" %>



<%
    String publishing_house_name = request.getParameter("publishing_house_name");
    String city = request.getParameter("city");
    String address = request.getParameter("address");
    String country = request.getParameter("country");

    PublishingHouse publishingHouse = new PublishingHouse(publishing_house_name,city,address,country);

    JdbcPublishingHouseRepository publishingHouseRepo= new JdbcPublishingHouseRepository();

    publishingHouseRepo.addPublishingHouse(publishingHouse);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/publishinghouseallhtml.jsp"/>