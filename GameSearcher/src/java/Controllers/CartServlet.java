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

import Models.CartAction;
import Models.CheckoutResult;
import Models.ShoppingCart;
import Services.CheckoutService;
import Views.CheckoutView;
import Views.ShoppingCartView;
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
                CheckoutResult result = checkout.performCheckout();
                request.setAttribute("checkout", new CheckoutView(result, checkout.getOrdersViewable()));
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
