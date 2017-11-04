<%-- 
    Document   : game_info.jsp
    Created on : 3-Nov-2017, 3:25:29 PM
    Author     : cmcarthur
--%>

<%@page import="Views.GameDetailsViewable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <%
            GameDetailsViewable game = (GameDetailsViewable)request.getAttribute("game");
        %>
        <div class="container">
            <%= game.toHTML() %>
        </div>
    </body>
</html>
