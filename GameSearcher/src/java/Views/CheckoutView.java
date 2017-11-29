/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private final ArrayList<OrderViewable> orders;

    public CheckoutView(CheckoutResult result, ArrayList<OrderViewable> orders) {
        this.result = result;
        this.orders = orders;
    }
       
    @Override
    public String toHTML() {
        if(result.isSuccess())
        {
                        String retval = "<h1>You have received email confirmation about your order.</h1>"
                    + "<hr><div class=\"row\">\n" +
"                <div class=\"col-xs-12\">\n" +
"                    <table class=\"table table-hover\">\n" +
"                        <thead>\n" +
"                            <tr>\n" +
"                                <th>Email</th>\n" +
"                                <th>Game Name</th>\n" +
"                                <th>Quantity</th>\n" +
"                                <th>Purchased On</th>\n" +
"                            </tr>\n" +
"                        </thead>\n" +
"                        <tbody>\n";

                        for(OrderViewable order : orders)
                        {
                            retval += order.toHTML();
                        }
retval += "                        </tbody>\n" +
"                    </table>\n" +
"                    \n" +
"                </div>\n" +
"            </div>";

return retval;
        }
        else
            return "<h1>There was an issue processing your order due to: " + result.getDesc() + ".</h1>";
    }
    
}
