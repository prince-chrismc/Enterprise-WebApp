/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.User;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class UsersTableViewable implements WebViewable {

    private final ArrayList<User> users;

    public UsersTableViewable(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toHTML() {
        String retval = "<table class=\"table table-hover\">\n"
                + "<thead>\n"
                + "<tr>\n"
                + "<th>Email</th>\n"
                + "<th>First Name</th><th>Last Name</th></tr></thead><tbody>\n";
        for (User user : users) {
            retval += "<tr><td>";
            retval += user.getEmail();
            retval += "</td><td>";
            retval += user.getFirst_name();
            retval += "</td><td>";
            retval += user.getLast_name();
            retval += "</td></tr>";
        }

        retval += "</tbody></table>";

        return retval;
    }

}
