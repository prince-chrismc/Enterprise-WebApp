<%-- 
    Document   : sign_up
    Created on : 29-Oct-2017, 8:18:40 PM
    Author     : cmcarthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign-up Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Fill in your information below!</h1>
            <form action="register" method="post">
                <table>
                    <tr><td><input type="hidden" name="action" value="register"/></td></tr>
                    
                    <tr><td>E-mail</td><td><input type="text" name="email" required/></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" required/></td></tr>
                    <tr><td>First Name</td><td><input type="text" name="first" required/></td></tr>
                    <tr><td>Last Name</td><td><input type="text" name="last" required/></td></tr>        
                    
                    <tr><td></td><td><input type="submit" value="Register"/></td></tr>
                </table>
            </form>
    </body>
</html>
