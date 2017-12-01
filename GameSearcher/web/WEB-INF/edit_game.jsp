<%-- 
    Document   : edit_game
    Created on : 30-Nov-2017, 4:45:34 PM
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
<%@page import="Models.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Game Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            Game game = (Game) request.getAttribute("game");
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1>Edit Game Information Below</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em;"/>
                    </form>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-xs-7">
                    <form id="gameedit" action="admin" method="post" class="form-horizontal">
                        <input type="hidden" name="action" value="<%=AdminAction.EDIT_GAME%>"/>
                        <input type="hidden" name="game_id" value="<%=String.valueOf(game.getGame_id())%>"/>
                        <h1>Basic Information...</h1>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Name</label>
                            <div class="col-xs-10">
                                <input id="name" type="text" name="name" value="<%=game.getName()%>" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Description</label>
                            <div class="col-xs-10">
                                <input id="desc" type="text" name="desc" value="<%=game.getDescription()%>" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Number of Players</label>
                            <div class="col-xs-10">
                                <input id="num_players" type="number" name="num_players" value="<%=String.valueOf(game.getNum_players())%>" min="1" max="9" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Cooperative</label>
                            <div class="col-xs-10">
                                <select name="coop" class="form-control">
                                    <option value="0" <%= game.isCoop() ? "" : " seleceted"%>>No</option>
                                    <option value="1" <%= game.isCoop() ? " seleceted" : ""%>>Yes</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Developer</label>
                            <div class="col-xs-10">
                                <input id="dev" type="text" name="dev" value="" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Publisher</label>
                            <div class="col-xs-10">
                                <input id="pub" type="text" name="pub" value="<%=game.getDeveloper()%>" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Price</label>
                            <div class="col-xs-10">
                                <input id="price" type="number" name="price" value="<%=String.valueOf(game.getPrice())%>" min="1" max="50" step="0.01" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-5 control-label">Discount (Negative for users only)</label>
                            <div class="col-xs-7">
                                <input id="disc" type="number" name="disc" value="<%=String.valueOf(game.getDiscount())%>" min="-15" max="15" step="0.1" class="form-control"/>
                            </div>
                        </div>
                        <input type="submit" value="Update" class="btn btn-block"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
