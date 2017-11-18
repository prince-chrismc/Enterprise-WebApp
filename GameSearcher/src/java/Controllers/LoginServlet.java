/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author cmcarthur
 */
package Controllers;


import Models.LoginType;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.User;
import Services.LoginService;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {       
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();
        if(loginService.isValidUser(email, password))
        {
            User user = loginService.getUser();
            request.setAttribute("user", user);
            request.setAttribute("type", LoginType.LOGIN);
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getUser_id());
            session.setMaxInactiveInterval(30*60);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login_success.jsp");
            requestDispatcher.forward(request, response);
        }
        else
        {
            response.sendRedirect("");
        }
    }
}
