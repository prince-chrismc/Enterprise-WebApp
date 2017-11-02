<%-- 
    Document   : results
    Created on : 1-Nov-2017, 4:31:11 PM
    Author     : cmcarthur
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Search Results</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <%
        ArrayList<Game> games = (ArrayList<Game>)request.getAttribute("games");
        String pretty_html = "";
        for(Game game : games) {
            pretty_html += "<div class='row'><div class='col-xs-2'>" + game.getGame_id() + "</div><div class='col-xs-2'>" + game.getName() + "</div></div>";
        }
        %>
        <div class="container">
            <h1>Your Results are...</h1>
            <div class="col-xs-12">
                <%= pretty_html%>
            </div>
        </div>
    </body>
</html>
