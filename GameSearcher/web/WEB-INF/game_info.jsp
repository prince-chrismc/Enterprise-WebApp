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
        %>
        <div class="container">
            <%= game.toHTML() %>
            <div class="col-xs-offset-10 col-xs-2">
                <form action="index.jsp" method="GET">
                    <input type="submit" class="btn" value="Back" style="margin: 2em 1em;"/>
                </form>
            </div>
        </div>
    </body>
</html>
