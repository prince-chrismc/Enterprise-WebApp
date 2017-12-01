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

import Models.Console;
import Models.Game;
import Models.Genre;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author cmcarthur
 */
public class GameDetailsView implements WebViewable {

    private final Game game;
    private final boolean signed_in;

    public GameDetailsView(Game game, boolean signed_in) {
        this.game = (game != null) ? game : new Game();
        this.signed_in = signed_in;
    }

    @Override
    public String toHTML() {
        return "<div class='row'><div class='col-xs-8'><h1>" + game.getName() + "</h1></div>"
                + "<div class='col-xs-offset-2 col-xs-2'><form action='index.jsp' method='GET'>"
                + "<input type='submit' class='btn' value='Home' style='margin: 2em 1em;'/></form></div></div><hr>"
                + "<div class='row'><div class='col-xs-6'><img src='" + game.getFront_box_art()
                + "' style='width: 100%;'></div><div class='col-xs-6'><div class='row'><div class='col-xs-12'>"
                + "<p>" + getDescription() + "</p><hr></div></div><div class='row'><div class='col-xs-6'>"
                + "<p> Consoles: " + getConsoles() + "</p>"
                + "<p> Number of Players : " + String.valueOf(game.getNum_players()) + "</p>"
                + "<p> Cooperative: " + String.valueOf(game.isCoop()) + "</p>"
                + "<p> Genres: " + getGenres() + "</p></div><div class='col-xs-6'>"
                + "<p> Release Date: " + getDate() + "</p>"
                + "<p> Developer: " + getDev() + "</p>"
                + "<p> Publisher: " + getPub() + "</p>"
                + "<p> Price: " + getPrice() + "</p></div></div></div></div>";
    }

    private String getDescription() {
        if (game.getDescription().equals("")) {
            return "'No description is avaliable for this game!'";
        }
        return game.getDescription();
    }

    private String getConsoles() {
        String output = "";
        for (Console console : game.getConsoles()) {
            output += console.toString() + ", ";
        }
        if (output.endsWith(", ")) {
            output = output.substring(0, output.lastIndexOf(", "));
        }
        return output;
    }

    private String getGenres() {
        String output = "";
        for (Genre genre : game.getGenres()) {
            output += genre.getGenre() + ", ";
        }
        if (output.endsWith(", ")) {
            output = output.substring(0, output.lastIndexOf(", "));
        }
        return output;
    }

    private String getDate() {
        if (game.getRelease_date() == null) {
            return "Unknow";
        } else {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            return df.format(game.getRelease_date());
        }
    }

    private String getDev() {
        if (game.getDeveloper() == null) {
            return "Unknow";
        }
        return game.getDeveloper();
    }

    private String getPub() {
        if (game.getPublisher() == null) {
            return "Unknow";
        }
        return game.getPublisher();
    }

    private String getPrice() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        if (game.getDiscount() < 0.0 && signed_in) {
            return "$" + String.valueOf(formatter.format(game.getPrice() - Math.abs(game.getDiscount()))) + " <i>SAVINGS: $" + String.valueOf(formatter.format(Math.abs(game.getDiscount()))) + "</i>";
        } else if (game.getDiscount() > 0) {
            return "$" + String.valueOf(formatter.format(game.getPrice() - Math.abs(game.getDiscount()))) + " <i>SAVINGS: $" + String.valueOf(formatter.format(Math.abs(game.getDiscount()))) + "</i>";
        } else {
            return "$" + String.valueOf(formatter.format(game.getPrice()));
        }
    }
}
