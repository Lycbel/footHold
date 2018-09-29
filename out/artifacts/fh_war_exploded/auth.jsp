<%--
  Created by IntelliJ IDEA.
  User: lycbel
  Date: 11/3/2017
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modules.User" %>
<%

    User usr;
    if(session.getAttribute("logged")==null){
        response.sendRedirect("/Auth/loginAndSignup.jsp");
    }


%>
