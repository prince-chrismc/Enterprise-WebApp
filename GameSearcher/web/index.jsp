<%-- 
    Document   : index
    Created on : 25-Oct-2017, 12:46:37 PM
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

<%@page import="Views.LandingPageUserSection"%>
<%@page import="Views.GenreOptionView"%>
<%@page import="Models.SearchCriteria"%>
<%@page import="Views.ConsoleOptionView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="res/js/CookieHandler.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <h1>Hello World!</h1>
                    <h3>Welcome to this online video game store!</h3>
                    <hr>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <h2>Search for a game...</h2>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.NAME%>"/>
                            <div class="col-xs-2">
                                <label class="control-label">Name</label>
                            </div>
                            <div class="col-xs-8">
                                <input type="text" name="criteria_val" class="form-control" placeholder="Jak"/>
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" value="Search" class="btn"/>
                            </div>
                        </form>
                    </div>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.CONSOLE%>"/>
                            <div class="col-xs-2">
                                <label class="control-label">Console</label>
                            </div>
                            <div class="col-xs-8">
                                <select name="criteria_val" class="form-control">
                                    <%= new ConsoleOptionView().toHTML()%>
                                </select>
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" value="Search" class="btn"/>
                            </div>
                        </form>
                    </div>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.GENRE%>"/>
                            <div class="col-xs-2">
                                <label class="control-label">Genre</label>
                            </div>
                            <div class="col-xs-8">
                                <select name="criteria_val" class="form-control">
                                    <%= new GenreOptionView().toHTML()%>
                                </select>
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" value="Search" class="btn"/>
                            </div>
                        </form>
                    </div>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.YEAR%>"/>
                            <div class="col-xs-2">
                                <label class="control-label">Year</label>
                            </div>
                            <div class="col-xs-8">
                                <input type="number" name="criteria_val" class="form-control" min="1996" max="2008" value="2002"/>
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" value="Search" class="btn"/>
                            </div>
                        </form>
                    </div>

                    <h2>Check the games on sale...</h2>
                    <form action="search" method="post">
                        <input type="hidden" name="criteria" value="<%= SearchCriteria.DISCOUNT%>"/>
                        <input type="submit" value="Browse" class="btn  btn-block"/>
                    </form>
                </div>

                <div id="no_user" class="col-xs-offset-1 col-xs-3">
                    <%= new LandingPageUserSection(request).toHTML()%>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $('form#logout').submit(function () {
                delete_cookie('gamesearcher_user');
                return true;
            });
        </script>
        <script type="text/javascript">
            $('form#login').submit(function () {
                if (jQuery.trim($("#email").val()) == '') {
                    $("#login_box").prepend("<div class='alert alert-danger alert-dismissable fade in'>" +
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no email provided.</div>");
                    return false;
                }

                var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                if (!emailReg.test(jQuery.trim($("#email").val()))) {
                    $("#login_box").prepend("<div class='alert alert-danger alert-dismissable fade in'>" +
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> Your so called email does not match the support email format.</div>");
                    return false;
                }

                if (jQuery.trim($("#pw").val()) == '') {
                    $("#login_box").prepend("<div class='alert alert-danger alert-dismissable fade in'>" +
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no password provided.</div>");
                    return false;
                }
                return true;
            });
        </script>
        <script type="text/javascript">
            // idea from https://stackoverflow.com/a/133997/8480874
            function recover() {
                //alert('button clicked');
                if (jQuery.trim($("#email").val()) == '') {
                    $("#login_box").prepend("<div class='alert alert-danger alert-dismissable fade in'>" +
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no email provided.</div>");
                    return false;
                }

                var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                if (!emailReg.test(jQuery.trim($("#email").val()))) {
                    $("#login_box").prepend("<div class='alert alert-danger alert-dismissable fade in'>" +
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> Your so called email does not match the support email format.</div>");
                    return false;
                }

                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "user");

                var email = document.createElement("input");
                email.setAttribute("type", "hidden");
                email.setAttribute("name", "email");
                email.setAttribute("value", $("#email").val());
                form.appendChild(email);

                var action = document.createElement("input");
                action.setAttribute("type", "hidden");
                action.setAttribute("name", "action");
                action.setAttribute("value", "RECOVER");
                form.appendChild(action);

                document.body.appendChild(form);
                form.submit();

            }
        </script>
    </body>
</html>
