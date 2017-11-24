/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ShoppingCart;
import Views.ShoppingCartView;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {
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
        
        ShoppingCart cart = new ShoppingCart(request.getParameter("user_email"));
        
        if(cart.addToCart(Integer.parseInt(request.getParameter("game_id")), Integer.parseInt(request.getParameter("qty")))) {
            
            request.setAttribute("cart", new ShoppingCartView(cart));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/cart.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("");
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
}
