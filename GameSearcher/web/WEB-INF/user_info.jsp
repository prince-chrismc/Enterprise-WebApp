<%-- 
    Document   : user_info
    Created on : 28-Nov-2017, 6:26:20 PM
    Author     : cmcarthur
--%>

<%@page import="Models.User"%>
<%@page import="Models.UserAction"%>
<%@page import="Models.CreditCardType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Your Information</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            UserAction action = (UserAction)request.getAttribute("action");
            User user = (User)request.getAttribute("user");
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1>Fill in your information below!</h1>
                </div>
                <div class="col-xs-offset-2 col-xs-2">
                    <form action="index.jsp" method="GET">
                        <input type="submit" class="btn" value="Back" style="margin: 2em 1em;"/>
                    </form>
                </div>
            </div>
            
            <hr>
            <div class="row">
                <div class="col-xs-8">
                    <form id="signup" action="register" method="post" class="form-horizontal">
                        <h1>Basic Information...</h1>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">First Name</label>
                            <div class="col-xs-10">
                                <input id="first" type="text" name="first" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Last Name</label>
                            <div class="col-xs-10">
                                <input id="last" type="text" name="last" class="form-control"/>
                            </div>
                        </div>
                        
                        <div class="col-xs-offset-2 col-xs-10">
                            <div class="row"><input type="submit" value="Register" class="btn  btn-block"/></div>
                        </div>
                        
                        <h2>Additional Information...</h2>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Address Line 1</label>
                            <div class="col-xs-10">
                                <input type="text" name="addr1" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Address Line 2</label>
                            <div class="col-xs-10">
                                <input type="text" name="addr2" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">City</label>
                            <div class="col-xs-10">
                                <input type="text" name="city" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">State</label>
                            <div class="col-xs-10">
                                <input type="text" name="state" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Zipcode</label>
                            <div class="col-xs-10">
                                <input type="text" name="zip" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Country</label>
                            <div class="col-xs-10">
                                <input type="text" name="country" class="form-control"/>
                            </div>
                        </div>
                        <h2>Card Information...</h2>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Card Type</label>
                            <div class="col-xs-10">
                                <select name="type" class="form-control">
                                    <option><%=CreditCardType.VISA%></option>
                                    <!--<option>MASTERCARD</option>-->
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Card Number</label>
                            <div class="col-xs-10">
                                <input type="number" name="number" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">CVV</label>
                            <div class="col-xs-10">
                                <input type="number" name="cvv" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Expiration</label>
                            <div class="col-xs-10">
                                <input type="date" name="exp" min="2017-18-02" class="form-control"/>
                            </div>
                        </div>
                    </form>
                    <br><br>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $('form#signup').submit(function() {
                            
                if(jQuery.trim($("#first").val()) == '') {
                    $("#email").parent().parent().prepend("<div class='alert alert-danger alert-dismissable fade in'>" + 
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no first name provided.</div>");
                    return false;            
                }
                
                if(jQuery.trim($("#last").val()) == '') {
                    $("#email").parent().parent().prepend("<div class='alert alert-danger alert-dismissable fade in'>" + 
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no last name provided.</div>");
                    return false;            
                }
                
                return true; // https://stackoverflow.com/a/8053433/8480874
            })
        </script>
    </body>
</html>

