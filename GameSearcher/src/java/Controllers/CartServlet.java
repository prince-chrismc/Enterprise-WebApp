/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.CartAction;
import Models.ShoppingCart;
import Services.CheckoutService;
import Views.CheckoutView;
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

        CartAction action = CartAction.valueOf(request.getParameter("action")); // https://stackoverflow.com/a/7056979/8480874
        boolean retval = false;

        switch (action) {
            case ADD:
                retval = cart.addToCart(Integer.parseInt(request.getParameter("game_id")), Integer.parseInt(request.getParameter("qty")));
                break;
            case REMOVE:
                retval = cart.removeFromCart(Integer.parseInt(request.getParameter("game_id")));
                break;
            case CLEAR:
                retval = cart.clearCart();
                break;
            case VIEW:
                retval = true;
                break;
            case CHECKOUT:
                CheckoutService checkout = new CheckoutService(cart);
                request.setAttribute("checkout", new CheckoutView(checkout.performCheckout()));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/checkout.jsp");
                requestDispatcher.forward(request, response);
                return;
            default:
                break;
        }

        if (retval) {
            request.setAttribute("cart", new ShoppingCartView(cart));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/cart.jsp");
            requestDispatcher.forward(request, response);
        } else {
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
