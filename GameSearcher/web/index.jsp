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
        <h1>Hello World!</h1>
        <h1>Please login...</h1>
        <form action="login" method="post">
            <table>
                <tr><td>User Name</td><td><input type="text" name="email"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password"/></td></tr>
                <tr><td></td><td><input type="submit" value="Login"/></td></tr>
            </table>
        </form>
    </body>
</html>
