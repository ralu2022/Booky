<%@ page import="com.booky.homelibrary.model.PublishingHouse" %>
<%@ page import="com.booky.homelibrary.repository.JdbcPublishingHouseRepository" %>


<%

  String publishingHouseName = request.getParameter("publishing_house_name");
  JdbcPublishingHouseRepository publishingHouseRepo = new JdbcPublishingHouseRepository();


  publishingHouseRepo.deletePublishingHouse(publishingHouseName);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/publishinghouseallhtml.jsp"/>