/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.AdminAction;
import Models.User;
import Services.CookieHandler;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class UsersTableViewable implements WebViewable {
    public enum TableType {
        LOCK,
        UNLOCK,
        LOGGED;
    }
    
    private final ArrayList<User> users;
    private final TableType type;

    public UsersTableViewable(ArrayList<User> users, TableType type) {
        this.users = users;
        this.type = type;
    }

    @Override
    public String toHTML() {
        switch(type)
        {
            case LOCK:
            case UNLOCK:
                return GetLockChangeTable();
            case LOGGED:
                return GetLoggedTable();
        }
        return "";
    }
    
    private String GetLockChangeTable() {
        String retval = "<table class=\"table table-hover\">\n"
                + "<thead>\n"
                + "<tr>\n"
                + "<th>Email</th>\n"
                + "<th>First Name</th><th>Last Name</th><th></th></tr></thead><tbody>\n";
        for (User user : users) {
            retval += "<tr><td>";
            retval += user.getEmail();
            retval += "</td><td>";
            retval += user.getFirst_name();
            retval += "</td><td>";
            retval += user.getLast_name();
            retval += "</td><td>";
            retval += GetLink(user);
            retval += "</td></tr>";
        }

        retval += "</tbody></table>";

        return retval;
    }
    
    private String GetLink(User user)
    {
        switch(type)
        {
            case LOCK:
                return "<a href='admin?email=" + user.getEmail() + "&action=" + AdminAction.LOCK + "'>Lock</a>";
            case UNLOCK:
                return "<a href='admin?email=" + user.getEmail() + "&action=" + AdminAction.UNLOCK + "'>Unock</a>";
        }
        return "";
    }
    
    
    private String GetLoggedTable() {
        String retval =  "<table class=\"table table-hover\">\n"
                + "<thead>\n"
                + "<tr>\n"
                + "<th>Email</th>\n"
                + "<th>Time</th></tr></thead><tbody>\n";
        
                for (User user : users) {
            retval += "<tr><td>";
            retval += user.getEmail();
            retval += "</td><td>";
            retval += user.getLast_login();
            retval += "</td></tr>";
        }

        retval += "</tbody></table>";

        return retval;
    }

}
