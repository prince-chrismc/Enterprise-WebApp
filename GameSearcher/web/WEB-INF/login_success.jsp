<%-- 
    Document   : login_success
    Created on : 25-Oct-2017, 1:10:21 PM
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

<%@page import="Views.LoginForwardButtons"%>
<%@page import="Views.LoginTypeView"%>
<%@page import="Models.LoginType"%>
<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Success</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            User user = (User) request.getAttribute("user");
            LoginTypeView status = new LoginTypeView((LoginType) request.getAttribute("type"));
            LoginForwardButtons buttons = new LoginForwardButtons(user.isAdmin());
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <h1>Hello <%= user.getFirst_name()%></h1>
                    <%= status.toHTML()%>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" value="Home" class="btn btn-block"/>
                    </form>
                </div>
                <%= buttons.toHTML()%>
            </div>
        </div>
    </body>
</html>
