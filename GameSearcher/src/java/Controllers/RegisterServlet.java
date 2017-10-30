/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
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
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        
        if(action.equals("redirect"))
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/sign_up.jsp"); // https://stackoverflow.com/questions/2047122/requestdispatcher-forward-vs-httpservletresponse-sendredirect
            requestDispatcher.forward(request, response);
        }
        else if(action.equals("register"))
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String first = request.getParameter("first");
            String last = request.getParameter("last");
            
            RegisterService regit = new RegisterService(email, password, first, last);
            
            User user = regit.getUser();
            
            if(user != null)
            {
                request.setAttribute("user", user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login_success.jsp");
                requestDispatcher.forward(request, response);
            }
            else
            {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/sign_up.jsp");
                requestDispatcher.forward(request, response);
            }
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
    }// </editor-fold>

}