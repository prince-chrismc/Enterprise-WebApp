/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Gateway.UserGateway;
import Models.AdminAction;
import Models.CartAction;
import Models.RegistrationAction;
import Models.User;
import Models.UserAction;
import Services.CookieHandler;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cmcarthur
 */
public class LandingPageUserSection implements WebViewable {
    private final boolean is_signedin;
    private final boolean is_admin;
    private final String user_email;

    public LandingPageUserSection(HttpServletRequest request) {
        this.is_signedin = CookieHandler.IsUserSignedIn(request);
        if(is_signedin) {
            user_email = CookieHandler.GetUserEmail(request);
            User user = UserGateway.FindUserBasicInfoByEmail(user_email);
            is_admin = user.isAdmin();
        }
        else {
            is_admin = false;
            user_email = "";
        }
    }

    @Override
    public String toHTML() {
        if(is_admin) {
            return "<div class='row'>\n" +
                    "<h2>Your Panel...</h2>\n" +
"                        <div class='col-xs-12'><div class='row'>\n" +
"                            <form action='admin' method='post'>\n" +
"                                <input type='hidden' name='action' value='" + AdminAction.VIEW + "'/>\n" +
"                                <input type='submit' value='View' class='btn btn-block'/>\n" +
"                            </form>\n" +
"                        </div></div>\n" +
"                    </div>\n" +
"                    <div class='row'>\n" +
"                        <h3>View Cart...</h3>\n" +
"                        <form action='cart' method='post' class='form-horizontal'>\n" +
"                            <input type='hidden' name='user_email' value='" +  user_email + "'/>\n" +
"                            <input type='hidden' name='action' value='" +  CartAction.VIEW + "'/>\n" +
"                            <input type='submit' value='Checkout' class='btn btn-block'/>\n" +
"                        </form>\n" +
"                    </div>\n" +
"                    <div class='row'>\n" +
"                        <h3>Logout...</h3>\n" +
"                        <form id='logout' action='index.jsp' method='post' class='form-horizontal'>\n" +
"                            <input type='submit' value='Logout' class='btn btn-block'/>\n" +
"                        </form>\n" +
"                    </div>";
        }       
        if(is_signedin) {
            return "<div class='row'>\n" +
"                        <h2>View Cart...</h2>\n" +
"                        <form action='cart' method='post' class='form-horizontal'>\n" +
"                            <input type='hidden' name='user_email' value='" +  user_email + "'/>\n" +
"                            <input type='hidden' name='action' value='" +  CartAction.VIEW + "'/>\n" +
"                            <input type='submit' value='Checkout' class='btn btn-block'/>\n" +
"                        </form>\n" +
"                    </div>\n" +
"                    <div class='row'>\n" +
"                        <h2>Your information...</h2>\n" +
"                        <div class='col-xs-12'><div class='row'>\n" +
"                            <form action='user' method='post'>\n" +
"                                <input type='hidden' name='action' value='" + UserAction.VIEW + "'/>\n" +
"                                <input type='submit' value='View' class='btn btn-block'  style='margin-bottom: 1em;'/>\n" +
"                            </form>\n" +
"                        </div></div>\n" +
"                        <div class='col-xs-12'><div class='row'>\n" +
"                            <form action='user' method='post'>\n" +
"                                <input type='hidden' name='action' value='" + UserAction.EDIT + "'/>\n" +
"                                <input type='submit' value='Edit' class='btn btn-block'/>\n" +
"                            </form>\n" +
"                        </div></div>\n" +
"                    </div>\n" +
"                    <div class='row'>\n" +
"                        <h3>Logout...</h3>\n" +
"                        <form id='logout' action='index.jsp' method='post' class='form-horizontal'>\n" +
"                            <input type='submit' value='Logout' class='btn btn-block'/>\n" +
"                        </form>\n" +
"                    </div>";
        } 
        else {
            return "<div id='login_box' class='row'>\n" +
"                        <h2>Please login...</h2>\n" +
"                        <form id='login' action='login' method='post' class='form-horizontal'>\n" +
"                            <div class='form-group'>\n" +
"                                <label class='col-xs-3 control-label'>Email</label>\n" +
"                                <div class='col-xs-9'>\n" +
"                                    <input id='email' type='text' name='email' class='form-control'/>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                            <div class='form-group'>\n" +
"                                <label class='col-xs-3 control-label'>Password</label>\n" +
"                                <div class='col-xs-9'>\n" +
"                                    <input id='pw' type='password' name='password' class='form-control'/>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                            <input type='submit' value='Login' class='btn btn-block'/>\n" +
"                        </form>\n" +
"                    </div>\n" +
"                    <div class='row'>                \n" +
"                    <button onclick='recover()' class='btn btn-block'  style='margin-top: 1em;'>Recover Password</button>\n" +
"                    </div>\n" +
"                    <div class='row'>                \n" +
"                        <h2>...Or sign up</h2>\n" +
"                        <form action='register' method='post'>\n" +
"                            <input type='hidden' name='action' value='" + RegistrationAction.REDIRECT + "'/>\n" +
"                            <input type='submit' value='Register' class='btn  btn-block'/>\n" +
"                        </form>\n" +
"                    </div>";
        }
        
    }
}
