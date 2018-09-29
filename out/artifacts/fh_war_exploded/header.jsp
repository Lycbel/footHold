<%--
  Created by IntelliJ IDEA.
  User: lycbel
  Date: 11/3/2017
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modules.User" %>
<%@ page import="modules.Owner" %>
<head>
    <link rel="stylesheet" type="text/css" href="/css/header.css"/>
</head>
<%
    boolean logged = true;
    User user =  (User) session.getAttribute("user");
    if(session.getAttribute("logged")==null){
       logged = false;
    }

    %>
<div class="topnav" >
    <a class="active" href="/index.jsp">Home</a>
    <%if(!logged){%>
    <a href="/Auth/loginAndSignup.jsp">Login/Signup</a>
    <%}else{%>
    Welcome! <%=user.getFirstName()+" "%>
    <a href="/userProfile.jsp">view profile</a>
    <a href="/reservationHistory.jsp">view reservations</a>
    <a href="/logout.jsp">logout</a>
    <a href="/Auth/changePassWord.jsp">Change Pssword</a>
    <a href="/uploadHouse.jsp">Upload a House</a>
    <%}%>
</div>

<div style="padding-left:16px">
    <h2>we Provide profesional service</h2>

</div>


