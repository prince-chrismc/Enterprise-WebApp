/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.GameGateway;
import Models.Game;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cmcarthur
 */
public class UpdateGameService {

    private final HttpServletRequest request;

    public UpdateGameService(HttpServletRequest request) {
        this.request = request;
    }
    
    public boolean UpdateAllFeilds() {
        Game game = new Game();
        
        game.setGame_id(Integer.parseInt(request.getParameter("game_id")));
        game.setName(request.getParameter("name"));
        game.setDescription(request.getParameter("desc"));
        game.setNum_players(Integer.parseInt(request.getParameter("num_players")));
        game.setCoop(Boolean.parseBoolean(request.getParameter("coop")));
        game.setDeveloper(request.getParameter("dev"));
        game.setPublisher(request.getParameter("pub"));
        game.setPrice(Double.parseDouble(request.getParameter("price")));
        game.setDiscount(Double.parseDouble(request.getParameter("disc")));
        
        GameGateway updater = new GameGateway(game);
        return updater.Update();
    }
}
