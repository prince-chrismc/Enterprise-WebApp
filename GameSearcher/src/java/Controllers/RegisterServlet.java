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
import Services.RegisterService;
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

        switch (action) {
            case REDIRECT:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/sign_up.jsp"); // https://stackoverflow.com/questions/2047122/requestdispatcher-forward-vs-httpservletresponse-sendredirect
                requestDispatcher.forward(request, response);
                break;
            case REGISTAR:
                HandleRegisterNewUser(request, response);
                break;
            case UPDATE:
                // TO DO
                break;
            default:
                response.sendRedirect("");
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void HandleRegisterNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String first = request.getParameter("first");
        String last = request.getParameter("last");

        if (ShouldUsePartialRegister(request)) {
            RegisterService regit = new RegisterService(email, password, first, last);
            user = regit.getUser();
        } else {
            String addr1 = request.getParameter("addr1");
            String addr2 = request.getParameter("addr2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String country = request.getParameter("country");
            String type = request.getParameter("type");
            String number = request.getParameter("number");
            String cvv = request.getParameter("cvv");
            String exp = request.getParameter("exp");

            RegisterService regit = new RegisterService(email, password, first, last, addr1, addr2, city, state, zip, country, type, number, cvv, exp);
            user = regit.getUser();
        }

        if (user != null) {
            request.setAttribute("user", user);
            request.setAttribute("type", LoginType.REGISTER);
            CookieHandler.SetNewCookie(response, user.getEmail());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login_success.jsp");
            requestDispatcher.forward(request, response);
        } else {
            // Failed to add to DB
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/sign_up.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private boolean ShouldUsePartialRegister(HttpServletRequest request) {
        return request.getParameter("addr1").isEmpty()
                && request.getParameter("addr2").isEmpty()
                && request.getParameter("city").isEmpty()
                && request.getParameter("state").isEmpty()
                && request.getParameter("zip").isEmpty()
                && request.getParameter("country").isEmpty()
                && request.getParameter("type").isEmpty()
                && request.getParameter("number").isEmpty()
                && request.getParameter("cvv").isEmpty()
                && request.getParameter("exp").isEmpty();
    }
}
