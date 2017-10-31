<%-- 
    Document   : index
    Created on : 25-Oct-2017, 12:46:37 PM
    Author     : cmcarthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            
            <div class="row">
                <div class="col-xs-12">
                    <h1>Hello World!</h1>
                    <hr>
                </div>
            </div>
            
            <div class="row">
                <div class="col-xs-8">
                    <h1>Search for a game...</h1>
                    <form action="search" method="post">
                        <table>
                            <tr><td>name</td><td><input type="text" name="name"/></td></tr>
                            <tr><td></td><td><input type="submit" value="Search"/></td></tr>
                        </table>
                    </form>
                </div>
                
                <div class="col-xs-4">
                    <div class="row">
                        <h1>Please login...</h1>
                        <form action="login" method="post">
                            <table>
                                <tr><td>E-mail</td><td><input type="text" name="email"/></td></tr>
                                <tr><td>Password</td><td><input type="password" name="password"/></td></tr>
                                <tr><td></td><td><input type="submit" value="Login"/></td></tr>
                            </table>
                        </form>
                    </div>
                    <div class="row">                
                        <h1>... Or Sign up</h1>
                        <form action="register" method="post">
                            <table>
                                <tr><td></td><td><input type="hidden" name="action" value="redirect"/></td></tr>
                                <tr><td></td><td><input type="submit" value="Register"/></td></tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
