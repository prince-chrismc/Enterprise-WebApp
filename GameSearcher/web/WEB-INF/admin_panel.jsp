<%-- 
    Document   : admin_panel
    Created on : 29-Nov-2017, 11:50:26 AM
    Author     : cmcarthur

    MIT License

    Copyright (c) 2017 Chris Mc, prince.chrismc(at)gmail(dot)com

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
--%>

<%@page import="Models.AdminAction"%>
<%@page import="Views.DiscountedGameResultView"%>
<%@page import="Models.User"%>
<%@page import="Views.UsersTableView"%>
<%@page import="Views.OrderView"%>
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
            User admin = (User) request.getAttribute("user");
            String recent_orders_table = "";
            for (OrderView order : (ArrayList<OrderView>) request.getAttribute("orders")) {
                recent_orders_table += order.toHTML();
            }

            String disc_games_table = "";
            for (DiscountedGameResultView disc_view : (ArrayList<DiscountedGameResultView>) request.getAttribute("disc_views")) {
                disc_games_table += disc_view.toHTML();
            }

            UsersTableView locked = (UsersTableView) request.getAttribute("locked");
            UsersTableView unlocked = (UsersTableView) request.getAttribute("unlocked");
            UsersTableView logged = (UsersTableView) request.getAttribute("logged");
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1><%=admin.getFirst_name()%>'s Panel</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em 1em 1em;"/>
                    </form>
                </div>
            </div>
            <div class="row"><hr></div>
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
                    <div class="row">
                        <h3>Games On Sale</h3>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Consoles</th>
                                    <th>Toggle To</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%= disc_games_table%>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-xs-offset-1 col-xs-3">
                    <div class="row">
                        <h3>Recently Logged In Accounts</h3>
                        <%= logged.toHTML()%>
                    </div>
                    <div class="row">
                        <h3>Edit A Game</h3>
                        <form action="admin" method="POST" id="gameedit">
                            <input type="hidden" name="action" value="<%=AdminAction.GAME_DETAILS%>"/>
                            <div class="input-group">
                                <input type="number" id="game_id" name="game_id" min="1" max="48" class="form-control" placeholder="Game ID">
                                <span class="input-group-btn">
                                    <input type="submit" class="btn btn-default" value="Go!"/>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $('form#gameedit').submit(function () {

                if (jQuery.trim($("#game_id").val()) == '') {
                    $("#game_id").parent().parent().prepend("<div class='alert alert-danger alert-dismissable fade in'>" +
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no game ID provided.</div>");
                    return false;
                }
                return true; // https://stackoverflow.com/a/8053433/8480874
            })
        </script>
    </body>
</html>
