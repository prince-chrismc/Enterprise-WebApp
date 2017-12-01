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
package Controllers;

import Gateway.UserGateway;
import Models.AdminAction;
import Models.RecoveryResult;
import Models.User;
import Models.UserAction;
import Services.CookieHandler;
import Services.MailMachine;
import Services.UserUpdateService;
import Views.RecoveryResultViewable;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmcarthur
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserAction action = UserAction.valueOf(request.getParameter("action"));
        if (action == UserAction.RECOVER) {
            HandlePasswordRecovery(request, response);
            return;
        }

        User user = UserGateway.FindUserCompleteByEmail(CookieHandler.GetUserEmail(request));
        if (user == null) {
            response.sendRedirect("");
            return;
        }
        if (user.isAdmin()) {
            request.setAttribute("action", AdminAction.VIEW);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin");
            requestDispatcher.forward(request, response);
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user_info.jsp");
        switch (action) {
            case VIEW:
                request.setAttribute("action", UserAction.VIEW);
                break;
            case EDIT:
                request.setAttribute("action", UserAction.EDIT);
                break;
            case UPDATE:
                UserUpdateService updater = new UserUpdateService(request);
                if (updater.UpdateAllFeilds()) {
                    request.setAttribute("action", UserAction.VIEW);
                    user = UserGateway.FindUserCompleteByEmail(CookieHandler.GetUserEmail(request));
                    break;
                }
                request.setAttribute("action", UserAction.EDIT);
                break;
            default:
                response.sendRedirect("");
                return;
        }
        request.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }

    private void HandlePasswordRecovery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/recovery.jsp");
        User user = UserGateway.FindUserCompleteByEmail(request.getParameter("email"));
        if (user != null) {
            user.setPassword("321pmet");
            UserGateway user_gateway = new UserGateway(user);
            if (user_gateway.Update()) {
                MailMachine mailer = MailMachine.getInstance();
                mailer.sendMessage(user.getEmail(), "Your temp password", "321pmet");
                request.setAttribute("action", new RecoveryResultViewable(RecoveryResult.SUCCESS));
            } else {
                request.setAttribute("action", new RecoveryResultViewable(RecoveryResult.SYS_ERR));
            }
        } else {
            request.setAttribute("action", new RecoveryResultViewable(RecoveryResult.USER_DNE));
        }
        requestDispatcher.forward(request, response);
    }
}
