<%-- 
    Document   : index
    Created on : 25-Oct-2017, 12:46:37 PM
    Author     : cmcarthur
--%>

<%@page import="Views.GenreOptionsViewable"%>
<%@page import="Models.SearchCriteria"%>
<%@page import="Views.ConsoleOptionsViewable"%>
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
                <div class="col-xs-6">
                    <h2>Search for a game...</h2>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.NAME.getValueAsString() %>"/>
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
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.CONSOLE.getValueAsString() %>"/>
                            <div class="col-xs-2">
                                <label class="control-label">Console</label>
                            </div>
                            <div class="col-xs-8">
                                <select name="criteria_val" class="form-control">
                                    <% ConsoleOptionsViewable console_options = new ConsoleOptionsViewable(); %>
                                    <%= console_options.toHTML() %>
                                </select>
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" value="Search" class="btn"/>
                            </div>
                        </form>
                    </div>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.GENRE.getValueAsString() %>"/>
                            <div class="col-xs-2">
                                <label class="control-label">Genre</label>
                            </div>
                            <div class="col-xs-8">
                                <select name="criteria_val" class="form-control">
                                    <% GenreOptionsViewable genre_options = new GenreOptionsViewable(); %>
                                    <%= genre_options.toHTML() %>
                                </select>
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" value="Search" class="btn"/>
                            </div>
                        </form>
                    </div>
                    <div class="row" style="margin: 1em 0em;">
                        <form action="search" method="post" class="form-horizontal">
                            <input type="hidden" name="criteria" value="<%= SearchCriteria.YEAR.getValueAsString() %>"/>
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
                        <input type="hidden" name="criteria" value="<%= SearchCriteria.DISCOUNT.getValueAsString() %>"/>
                        <input type="submit" value="Browse" class="btn  btn-block"/>
                    </form>
                </div>
                
                <div class="col-xs-offset-2 col-xs-4">
                    <div class="row">
                        <h2>Please login...</h2>
                        <form action="login" method="post" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Email</label>
                                <div class="col-xs-10">
                                    <input type="text" name="email" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Password</label>
                                <div class="col-xs-10">
                                    <input type="password" name="password" class="form-control"/>
                                </div>
                            </div>
                            <input type="submit" value="Login" class="btn btn-block"/>
                        </form>
                    </div>
                    <div class="row">                
                        <h2>...Or sign up</h2>
                        <form action="register" method="post">
                            <input type="hidden" name="action" value="redirect"/>
                            <input type="submit" value="Register" class="btn  btn-block"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
