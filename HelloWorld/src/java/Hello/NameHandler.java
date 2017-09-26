package Hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cmcarthur
 */
public class NameHandler {
     private String name;

    /** Creates a new instance of NameHandler */
    public NameHandler() {
       name = null;
    }

    public String getName() {
       return name;
    }

    public void setName(String name) {
       this.name = name;
    }
}
