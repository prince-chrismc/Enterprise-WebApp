/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.AdminAction;
import Models.UserAction;

/**
 *
 * @author cmcarthur
 */
public class LoginForwardButtons implements WebViewable {

    private final boolean isAdmin;

    public LoginForwardButtons(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toHTML() {
        if (isAdmin) {
            return "<div class='col-xs-2'><form action='admin' method='post'>"
                    + "<input type='hidden' name='action' value='" + AdminAction.VIEW + "'/>"
                    + "<input type='submit' value='View Your Panel' class='btn btn-block'/>"
                    + "</form></div>";
        } else {
            return "<div class='col-xs-2'><form action='user' method='post'>"
                    + "<input type='hidden' name='action' value='" + UserAction.VIEW + "'/>"
                    + "<input type='submit' value='View Your Info' class='btn btn-block'/>"
                    + "</form></div><div class='col-xs-2'><form action='user' method='post'>"
                    + "<input type='hidden' name='action' value='" + UserAction.VIEW + "'/>"
                    + "<input type='submit' value='Edit Your Info' class='btn btn-block'/>"
                    + "</form></div>";
        }
    }
}
