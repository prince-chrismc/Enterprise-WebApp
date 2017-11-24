<%-- 
    Document   : cart
    Created on : 23-Nov-2017, 7:25:25 PM
    Author     : cmcarthur
--%>

<%@page import="Views.ShoppingCartView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shopping Cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            ShoppingCartView cart_view = (ShoppingCartView)request.getAttribute("cart");
        %>        
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1>Your Cart contains...</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em 1em 1em;"/>
                    </form>
                </div>
            </div>
            <hr>
            <%= cart_view.toHTML() %>
        </div>
    </body>
</html>
