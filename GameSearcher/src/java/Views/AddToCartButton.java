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

import Models.CartAction;

/**
 *
 * @author cmcarthur
 */
public class AddToCartButton implements WebViewable {

    private final String user_email;
    private final int game_id;

    public AddToCartButton(String user_email, int game_id) {
        this.user_email = user_email;
        this.game_id = game_id;
    }

    @Override
    public String toHTML() {
        if (isUserValid()) {
            return "<div class='col-xs-offset-6 col-xs-6' style='margin-top: -10%;'><hr><form action='cart' method='POST'>"
                    + "<input type='hidden' name='user_email' value='" + user_email + "'/>"
                    + "<input type='hidden' name='game_id' value='" + game_id + "'/>"
                    + "<input type='hidden' name='action' value='" + CartAction.ADD + "'/>"
                    + "<div class='form-group'><label class='col-xs-2 control-label'>Quantity</label>"
                    + "<div class='col-xs-10'><input type='number' name='qty' min='1' max='99' value='1' class='form-control'  style='margin-bottom: 1em;'/>"
                    + "</div></div><input type='submit' class='btn btn-block' value='Add To Cart' style='margin-top: 1em;'/></form></div>";
        }
        return "";
    }

    private boolean isUserValid() {
        if (user_email == null || user_email.equals("")) {
            return false;
        }
        return true;
    }
}
