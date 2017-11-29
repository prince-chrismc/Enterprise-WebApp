<%-- 
    Document   : admin_panel
    Created on : 29-Nov-2017, 11:50:26 AM
    Author     : cmcarthur
--%>

<%@page import="Views.UsersTableViewable"%>
<%@page import="Views.OrderViewable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Administrator Panel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String recent_orders_table = "";
            for(OrderViewable order : (ArrayList<OrderViewable>)request.getAttribute("orders"))
            {
                recent_orders_table += order.toHTML();
            }
            UsersTableViewable locked = (UsersTableViewable)request.getAttribute("locked");
            UsersTableViewable unlocked = (UsersTableViewable)request.getAttribute("unlocked");
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1>Administration Panel</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em 1em 1em;"/>
                    </form>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-xs-8">
                    <div class="row">
                        <h3>Latest Orders</h3>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Email</th>
                                    <th>Game Name</th>
                                    <th>Quantity</th>
                                    <th>Purchased On</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%= recent_orders_table%>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <h3>Locked User Accounts</h3>
                        <%= locked.toHTML()%>
                    </div>
                    <div class="row">
                        <h3>Unlocked User Accounts</h3>
                        <%= unlocked.toHTML()%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
