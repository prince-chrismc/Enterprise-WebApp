<%-- 
    Document   : user_info
    Created on : 28-Nov-2017, 6:26:20 PM
    Author     : cmcarthur
--%>

<%@page import="Views.UserActionButton"%>
<%@page import="Views.UserActionFeildStatus"%>
<%@page import="Views.UserActionTitle"%>
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
            UserActionTitle title = new UserActionTitle(action);
            UserActionFeildStatus status = new UserActionFeildStatus(action);
            UserActionButton button = new UserActionButton(action);
            User user = (User)request.getAttribute("user");
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <h1><%=title.toHTML()%></h1>
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
                    <form id="user" action="user" method="post" class="form-horizontal">
                        <h1>Basic Information...</h1>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">First Name</label>
                            <div class="col-xs-10">
                                <input id="first" type="text" name="first" value="<%=user.getFirst_name()%>" class="form-control" <%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Last Name</label>
                            <div class="col-xs-10">
                                <input id="last" type="text" name="last" value="<%=user.getLast_name()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                            <%=button.toHTML()%>
                        <h2>Additional Information...</h2>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Address Line 1</label>
                            <div class="col-xs-10">
                                <input type="text" name="addr1" value="<%=user.getAddress1()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Address Line 2</label>
                            <div class="col-xs-10">
                                <input type="text" name="addr2" value="<%=user.getAddress2()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">City</label>
                            <div class="col-xs-10">
                                <input type="text" name="city" value="<%=user.getCity()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">State</label>
                            <div class="col-xs-10">
                                <input type="text" name="state" value="<%=user.getState()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Zipcode</label>
                            <div class="col-xs-10">
                                <input type="text" name="zip" value="<%=user.getZip()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Country</label>
                            <div class="col-xs-10">
                                <input type="text" name="country" value="<%=user.getCountry()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <h2>Card Information...</h2>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Card Type</label>
                            <div class="col-xs-10">
                                <select name="type" class="form-control" <%=status.toHTML()%>>
                                    <option><%=CreditCardType.VISA%></option>
                                    <!--<option>MASTERCARD</option>-->
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Card Number</label>
                            <div class="col-xs-10">
                                <input type="number" name="number" value="<%=user.getCredit_card_number()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">CVV</label>
                            <div class="col-xs-10">
                                <input type="number" name="cvv" value="<%=user.getCredit_card_cvv()%>" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-2 control-label">Expiration</label>
                            <div class="col-xs-10">
                                <input type="date" name="exp" min="2017-18-02" value="2019-18-07" class="form-control"<%=status.toHTML()%>/>
                            </div>
                        </div>
                            <%=button.toHTML()%>
                    </form>
                    <br><br>
                </div>
                <div class="col-xs-offset-1 col-xs-4">
                    <h2>Recent Transactions...</h2>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $('form#user').submit(function() {
                            
                if(jQuery.trim($("#first").val()) == '') {
                    $("#user").parent().parent().prepend("<div class='alert alert-danger alert-dismissable fade in'>" + 
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no first name provided.</div>");
                    return false;            
                }
                
                if(jQuery.trim($("#last").val()) == '') {
                    $("#user").parent().parent().prepend("<div class='alert alert-danger alert-dismissable fade in'>" + 
                            "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>" +
                            "<strong>Error!</strong> There was no last name provided.</div>");
                    return false;            
                }
                
                return true; // https://stackoverflow.com/a/8053433/8480874
            })
        </script>
    </body>
</html>

