<%-- 
    Document   : login_success
    Created on : 25-Oct-2017, 1:10:21 PM
    Author     : cmcarthur
--%>

<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <%
        User user = (User)request.getAttribute("user");
        %>
        <h1>Hello <%= String.valueOf(user.getUser_id()) %></h1>
        <h2>You have successfully logged in</h2>
    </body>
</html>
