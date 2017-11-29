<%-- 
    Document   : checkout
    Created on : 24-Nov-2017, 1:00:11 PM
    Author     : cmcarthur
--%>

<%@page import="Views.CheckoutView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Checkout Complete!</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            CheckoutView checkout_view = (CheckoutView)request.getAttribute("checkout");
        %>
        <div class="container">
            
            <div class="row">
                <div class="col-xs-8">
                    <%= checkout_view.toHTML() %>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Home" style="margin: 2em 1em;"/>
                    </form>
                </div>
                <hr>
            </div>
        </div>
    </body>
</html>
