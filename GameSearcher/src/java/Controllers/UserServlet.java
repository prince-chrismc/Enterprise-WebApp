/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Gateway.UserGateway;
import Models.LoginType;
import Models.User;
import Models.UserAction;
import Services.CookieHandler;
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
        if(user == null) {
            response.sendRedirect("");
        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user_info.jsp");
        switch(action)
        {
            case VIEW:
                request.setAttribute("action", UserAction.VIEW);
                break;
            case EDIT:
                request.setAttribute("action", UserAction.EDIT);
                break;
            case UPDATE:
                // TO DO
                // UserUpdate Service (request)
                request.setAttribute("action", UserAction.VIEW);
                break;
            default:
                response.sendRedirect("");
                break;
        }
        request.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }

}
