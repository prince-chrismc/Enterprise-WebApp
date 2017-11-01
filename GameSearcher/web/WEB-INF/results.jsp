<%-- 
    Document   : results
    Created on : 1-Nov-2017, 4:31:11 PM
    Author     : cmcarthur
--%>

<%@page import="java.util.Vector"%>
<%@page import="Models.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Search results</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <%
        Vector<Game> games = (Vector<Game>)request.getAttribute("games");
        %>
        <div class="container">
            <h1>Your Results are...</h1>
            <table>
                <tr><td>0</td><td><%= games.get(0).getName()%></td></tr>
            </table>
        </div>
    </body>
</html>
