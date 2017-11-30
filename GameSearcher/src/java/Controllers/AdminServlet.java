/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Gateway.GameGateway;
import Gateway.OrderGateway;
import Gateway.UserGateway;
import Models.AdminAction;
import Models.Game;
import Models.User;
import Services.CookieHandler;
import Services.LockingService;
import Services.Search.SearchByDiscountService;
import Services.UpdateGameService;
import Views.DiscountedGameResultView;
import Views.UsersTableViewable;
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
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = UserGateway.FindUserCompleteByEmail(CookieHandler.GetUserEmail(request));

        if (user == null) {
            response.sendRedirect("");
            return;
        }

        if (!user.isAdmin()) {
            response.sendRedirect("");
            return;
        }

        AdminAction action = AdminAction.valueOf(request.getParameter("action"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin_panel.jsp");
        String email;
        int game_id;

        switch (action) {
            case LOCK:
                email = request.getParameter("email");
                LockingService locker = new LockingService(email);
                locker.Lock();
                break;
            case UNLOCK:
                email = request.getParameter("email");
                LockingService unlocker = new LockingService(email);
                unlocker.Unlock();
                break;
            case EDIT_GAME:
                UpdateGameService updater = new UpdateGameService(request);
                if(updater.UpdateAllFeilds()) {
                    response.sendRedirect("game?id=" + request.getParameter("game_id"));
                    return;
                }
                else {
                    game_id = Integer.parseInt(request.getParameter("game_id"));
                    requestDispatcher = request.getRequestDispatcher("WEB-INF/edit_game.jsp");
                    request.setAttribute("game", GameGateway.FindGameByID(game_id));
                    requestDispatcher.forward(request, response);
                }
                break;
            case GAME_DETAILS:
                game_id = Integer.parseInt(request.getParameter("game_id"));
                requestDispatcher = request.getRequestDispatcher("WEB-INF/edit_game.jsp");
                request.setAttribute("game", GameGateway.FindGameByID(game_id));
                requestDispatcher.forward(request, response);
                break;
            case GAME_TOGGLE_DISC:
                game_id = Integer.parseInt(request.getParameter("id"));
                GameGateway game_entry = new GameGateway(game_id);
                game_entry.ToogleDiscount();
                break;
            default:
                break;
        }
        
        SearchByDiscountService by_discount = new SearchByDiscountService(true);
        ArrayList<Game> games = by_discount.getGames();
        ArrayList<DiscountedGameResultView> disc_views = new ArrayList<>();
        for(Game game : games) {
            disc_views.add(new DiscountedGameResultView(game));
        }
        
        request.setAttribute("disc_views", disc_views);
        request.setAttribute("orders", OrderGateway.GetMostRecentOrders());
        request.setAttribute("locked", new UsersTableViewable(UserGateway.FindAllLockedUsersBasicInfo(), UsersTableViewable.TableType.UNLOCK));
        request.setAttribute("unlocked", new UsersTableViewable(UserGateway.FindAllUnlockedUsersBasicInfo(), UsersTableViewable.TableType.LOCK));
        request.setAttribute("logged", new UsersTableViewable(UserGateway.FindRecentlyLoggedInUsersBasicInfoWithTime(), UsersTableViewable.TableType.LOGGED));
        request.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
