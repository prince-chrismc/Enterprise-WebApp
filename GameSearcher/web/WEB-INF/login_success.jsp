<%-- 
    Document   : login_success
    Created on : 25-Oct-2017, 1:10:21 PM
    Author     : cmcarthur
--%>

<%@page import="Models.UserAction"%>
<%@page import="Views.LoginTypeViewable"%>
<%@page import="Models.LoginType"%>
<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Success</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
        User user = (User)request.getAttribute("user");
        LoginTypeViewable status = new LoginTypeViewable((LoginType)request.getAttribute("type"));
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <h1>Hello <%= user.getFirst_name()%></h1>
                    <%= status.toHTML() %>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" value="Home" class="btn btn-block"/>
                    </form>
                </div>
                <div class="col-xs-2">
                    <form action="user" method="post">
                        <input type="hidden" name="action" value="<%=UserAction.VIEW%>"/>
                        <input type="submit" value="Your Info" class="btn btn-block"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
