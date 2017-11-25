/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.SearchCriteria;
import Services.Search.SearchByCriteriaService;
import Views.GameResultViewable;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet
{
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
        
        SearchCriteria criteria = SearchCriteria.valueOf(request.getParameter("criteria"));
        String criteria_val = request.getParameter("criteria_val");
        
        SearchByCriteriaService searcher = new SearchByCriteriaService(criteria, criteria_val);
        ArrayList<GameResultViewable> games = searcher.getViewableResults();
        
        if(games.size() > 0)
        {
            request.setAttribute("games", games);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/results.jsp");
            requestDispatcher.forward(request, response);
        }
        else
        {
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
