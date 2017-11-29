/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.LoginType;
import Models.RegistrationAction;
import Models.User;
import Services.CookieHandler;
import Services.UserRegisterService;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegistrationAction action = RegistrationAction.valueOf(request.getParameter("action"));

        RequestDispatcher requestDispatcher;
        switch (action) {
            case REDIRECT:
                requestDispatcher = request.getRequestDispatcher("WEB-INF/sign_up.jsp"); // https://stackoverflow.com/questions/2047122/requestdispatcher-forward-vs-httpservletresponse-sendredirect
                requestDispatcher.forward(request, response);
                break;
            case REGISTER:
                UserRegisterService regit = new UserRegisterService(request);
                if (regit.RegisterData()) {
                    request.setAttribute("user", regit.getUser());
                    request.setAttribute("type", LoginType.REGISTER);
                    CookieHandler.SetNewCookie(response, regit.getUser().getEmail());
                    requestDispatcher = request.getRequestDispatcher("WEB-INF/login_success.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // Failed to add to DB
                requestDispatcher = request.getRequestDispatcher("WEB-INF/sign_up.jsp");
                requestDispatcher.forward(request, response);
                break;
            default:
                response.sendRedirect("");
                break;
        }
    }
}
