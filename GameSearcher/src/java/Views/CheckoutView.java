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

import Models.CheckoutResult;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class CheckoutView implements WebViewable {

    private final CheckoutResult result;
    private final ArrayList<OrderView> orders;

    public CheckoutView(CheckoutResult result, ArrayList<OrderView> orders) {
        this.result = result;
        this.orders = orders;
    }

    @Override
    public String toHTML() {
        if (result.isSuccess()) {
            String retval = "<h1>You have received email confirmation about your order.</h1><hr><div class='row'><div class='col-xs-12'>"
                    + "<table class='table table-hover'><thead><tr><th>Email</th><th>Game Name</th><th>Quantity</th><th>Purchased On</th>"
                    + "</tr></thead><tbody>";

            for (OrderView order : orders) {
                retval += order.toHTML();
            }
            retval += "</tbody></table></div></div>";

            return retval;
        } else {
            return "<h1>There was an issue processing your order due to: " + result.getDesc() + ".</h1>";
        }
    }

}
