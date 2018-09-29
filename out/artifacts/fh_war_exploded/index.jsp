<%--
  Created by IntelliJ IDEA.
  User: lycbel
  Date: 11/3/2017
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/header.jsp" %>
<%@include file="/auth.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/search.css"/>
<body>
    <form action="search.jsp" method="post" class="form-wrapper">
        <input type="text" id="search" name="searchContent" placeholder="Search for..." required>
        <input type="submit" value="go" id="submit">
    </form>
</body>
</html>
