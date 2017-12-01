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
