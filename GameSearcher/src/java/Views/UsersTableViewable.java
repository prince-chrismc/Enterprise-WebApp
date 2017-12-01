/*
    MIT License

    Copyright (c) 2017 Chris Mc, prince.chrismc(at)gmail(dot)com

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 */
package Views;

import Models.AdminAction;
import Models.User;
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
        switch (type) {
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

    private String GetLink(User user) {
        switch (type) {
            case LOCK:
                return "<a href='admin?email=" + user.getEmail() + "&action=" + AdminAction.LOCK + "'>Lock</a>";
            case UNLOCK:
                return "<a href='admin?email=" + user.getEmail() + "&action=" + AdminAction.UNLOCK + "'>Unock</a>";
        }
        return "";
    }

    private String GetLoggedTable() {
        String retval = "<table class=\"table table-hover\">\n"
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
