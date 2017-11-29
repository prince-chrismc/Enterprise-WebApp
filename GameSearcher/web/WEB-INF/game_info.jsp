<%-- 
    Document   : game_info.jsp
    Created on : 3-Nov-2017, 3:25:29 PM
    Author     : cmcarthur
--%>

<%@page import="Views.AddToCartButton"%>
<%@page import="Services.CookieHandler"%>
<%@page import="Views.GameDetailsViewable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Game Details</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            GameDetailsViewable game = (GameDetailsViewable)request.getAttribute("game");
            AddToCartButton possible_button = new AddToCartButton(CookieHandler.GetUserEmail(request), Integer.parseInt(request.getParameter("id")));
        %>
        <div class="container">
            <%= game.toHTML() %>
            <%= possible_button.toHTML() %>
        </div>
    </body>
</html>
