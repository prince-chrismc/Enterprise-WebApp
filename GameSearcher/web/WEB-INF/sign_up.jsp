<%-- 
    Document   : sign_up
    Created on : 29-Oct-2017, 8:18:40 PM
    Author     : cmcarthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign-up Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Fill in your information below!</h1>
            <hr>
            <form action="register" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="register"/>
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
                <div class="form-group">
                    <label class="col-xs-2 control-label">First Name</label>
                    <div class="col-xs-10">
                        <input type="text" name="first" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-2 control-label">Last Name</label>
                    <div class="col-xs-10">
                        <input type="text" name="last" class="form-control"/>
                    </div>
                </div>
                <div class="col-xs-offset-2 col-xs-10">
                    <div class="row"><input type="submit" value="Register" class="btn  btn-block"/></div>
                </div>
            </form>
        </div>
    </body>
</html>
