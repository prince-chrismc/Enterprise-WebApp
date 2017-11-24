/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author cmcarthur
 */
public class AddToCartButton implements WebViewable{
    private final String user_email;
    private final int game_id;
    
    public AddToCartButton(String user_email, int game_id) {
        this.user_email = user_email;
        this.game_id = game_id;
    }
    
    @Override
    public String toHTML() {
        if(isUserValid())
        {
            return "<div class='col-xs-offset-6 col-xs-6' style='margin-top: -10%;'><hr><form action='cart' method='POST'>"
                    + "<input type='hidden' name='user_email' value='" + user_email + "'/>"
                    + "<input type='hidden' name='game_id' value='" + game_id + "'/>"
                    + "<div class='form-group'><label class='col-xs-2 control-label'>Quantity</label>"
                    + "<div class='col-xs-10'><input type='number' name='qty' min='1' max='99' value='1' class='form-control'  style='margin-bottom: 1em;'/>"
                    + "</div></div><input type='submit' class='btn btn-block' value='Add To Cart' style='margin-top: 1em;'/></form></div>";
        }
        return "";
    }
    
    private boolean isUserValid() {
        if(user_email == null || user_email.equals("")) return false;
        return true;
    }
}
