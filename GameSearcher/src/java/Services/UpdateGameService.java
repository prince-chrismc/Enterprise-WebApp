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
