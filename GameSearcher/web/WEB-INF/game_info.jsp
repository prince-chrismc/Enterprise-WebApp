<%-- 
    Document   : game_info.jsp
    Created on : 3-Nov-2017, 3:25:29 PM
    Author     : cmcarthur
--%>

<%@page import="Models.Game"%>
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
            Game game = (Game)request.getAttribute("game");
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                   <h1><%= game.getName() %></h1>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <img src="<%= game.getFront_box_art()%>" style="width: 100%;">
                </div>
                <div class="col-xs-6">
                    <p><%= game.getDescription() %></p>
                </div>
            </div>
            
        </div>
    </body>
</html>
