<%@ page import="DB.AuthDB" %>
<%@ page import="controls.AuthControl" %><%--
  Created by IntelliJ IDEA.
  User: lycbel
  Date: 11/5/2017
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/header.jsp" %>
<%@include file="/auth.jsp" %>
<%
    int type = 0; // means nothing to change.
  if(request.getParameter("submitted")!=null){
      User u = (User)session.getAttribute("user");
      AuthControl ac = new AuthControl();
      type= ac.changePassWord(u,request.getParameter("newPass"),request.getParameter("confirmPass"));

  }
  if(type==1){%>
<p>password successfully changed<p>
<%
    }else if(type == -1){
  %>
  <p>password not match<p>
<%
    }else  if(type == -2){%>
<p>need to fill all field<p>
   <% }
  if(type!=1){
%>

<form action="/Auth/changePassWord.jsp" method="post" id="mainForm">
    <table>
        <tr>
            <td>New Password:</td>
            <td><input type=password maxlength=20 name="newPass"></td>
        </tr>
        <tr>
            <td>Confirm:</td>
            <td><input type=password maxlength=20 name="confirmPass"></td>
        </tr>
        <tr>
            <td colspan=2 align=center><input type="submit" value="Change Password"></td>
        </tr>
        <input value = "1" name = "submitted" hidden="hidden">
    </table>
</form>

<%}%>
