<%-- 
    Document   : results
    Created on : 1-Nov-2017, 4:31:11 PM
    Author     : cmcarthur
--%>

<%@page import="Views.GameResultViewable"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Game Search Results</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
        ArrayList<GameResultViewable> games = (ArrayList<GameResultViewable>)request.getAttribute("games");
        String results_table = "";
        for(GameResultViewable game : games) { // https://knowm.org/iterating-through-a-collection-in-java/
            results_table += game.toHTML();
        }
        String user_email = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                    if(cookie.getName().equals("gamesearcher_user")) user_email = cookie.getValue();
            }
        }
        %>
        <div class="container">
            <%= user_email %>
            <div class="row">
                <div class="col-xs-8">
                    <h1>Your Results are...</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em 1em 1em;"/>
                    </form>
                </div>
            </div>
                    <hr>
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Consoles</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%= results_table%>
                        </tbody>
                    </table>
                    
                </div>
            </div>
        </div>
    </body>
</html>
