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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Search Results</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <%
        ArrayList<GameResultViewable> games = (ArrayList<GameResultViewable>)request.getAttribute("games");
        String results_table = "";
        for(GameResultViewable game : games) { // https://knowm.org/iterating-through-a-collection-in-java/
            results_table += game.toHTML();
        }
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1>Your Results are...</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em;"/>
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
