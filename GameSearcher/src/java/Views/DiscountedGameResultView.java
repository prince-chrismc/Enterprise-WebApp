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
package Views;

import Models.AdminAction;
import Models.Game;

/**
 *
 * @author cmcarthur
 */
public class DiscountedGameResultView implements WebViewable {

    private final Game game;

    public DiscountedGameResultView(Game game) {
        this.game = game;
    }

    @Override
    public String toHTML() {
        return "<tr'><td>" + game.getGame_id() + "</td><td>" + game.getName()
                + "</td><td>" + game.getConsolesArrayAsString() + "</td><td><a href='admin?action=" + AdminAction.GAME_TOGGLE_DISC + "&id=" + game.getGame_id()
                + "'>" + GetToggleTo() + "</a></td></tr>";
    }

    private String GetToggleTo() {
        if (game.getDiscount() < 0.0) {
            return "Public";
        } else {
            return "Users Only";
        }
    }
}
