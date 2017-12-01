/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

        User user = UserGateway.FindUserCompleteByEmail(CookieHandler.GetUserEmail(request));
        if(action != UserAction.RECOVER) {
            if (user == null) {
                response.sendRedirect("");
                return;
            }
        }
        if(action != UserAction.RECOVER) {
            if(user.isAdmin())
            {
                request.setAttribute("action", AdminAction.VIEW);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin");
                requestDispatcher.forward(request, response);
                return;
            }
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
            case RECOVER:
                requestDispatcher = request.getRequestDispatcher("WEB-INF/recovery.jsp");
                user = UserGateway.FindUserCompleteByEmail(request.getParameter("email"));
                if(user != null) {
                    user.setPassword("321pmet");
                    UserGateway user_gateway = new UserGateway(user);
                    if(user_gateway.Update()) {
                        MailMachine mailer = MailMachine.getInstance();
                        mailer.sendMessage(user.getEmail(), "Your temp password", "321pmet");
                        request.setAttribute("action", new RecoveryResultViewable(RecoveryResult.SUCCESS));
                    }
                    else {
                        request.setAttribute("action", new RecoveryResultViewable(RecoveryResult.SYS_ERR));
                    }
                }
                else {
                    request.setAttribute("action", new RecoveryResultViewable(RecoveryResult.USER_DNE));
                }
                requestDispatcher.forward(request, response);
                return;
            default:
                response.sendRedirect("");
                return;
        }
        request.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }

}
