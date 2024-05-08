<%@ page import="com.booky.homelibrary.model.User" %>
<%@ page import="com.booky.homelibrary.repository.JdbcUserRepository" %>


<%
  String user_name = request.getParameter("user_name");
  String password = request.getParameter("password");


  User user = new User(user_name,password);

  JdbcUserRepository userRepo = new JdbcUserRepository();

  userRepo.addUser(user);

%>

<meta http-equiv="Refresh" content="0; url='/Booky/index.jsp"/>