<%-- 
    Document   : newUser
    Created on : 23-Oct-2017, 1:42:33 PM
    Author     : cmcarthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New User</title>
    </head>
    <body>
               <div class="container-fluid">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>                        
                </button>
                <a class="navbar-brand" href="#">Logo</a>
              </div>
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">About</a></li>
                  <li><a href="#">Projects</a></li>
                  <li><a href="#">Contact</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
              </div>
            </div>
          </nav>
    
    
    <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
        <h1>Hello New User!</h1>
        
        <form:form method = "POST" action = "/HelloWeb/addUser">
         <table>
            <tr>
               <td><form:label path = "m_FirstName">Name</form:label></td>
               <td><form:input path = "m_FirstName" /></td>
            </tr>
            <tr>
               <td><form:label path = "m_LastName">Age</form:label></td>
               <td><form:input path = "m_LastName" /></td>
            </tr>
            <tr>
               <td><form:label path = "m_Email">id</form:label></td>
               <td><form:input path = "m_Email" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
        
        
        </div>
  </div>
    </div>
        <footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
               </div>
    </body>
</html>
