/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Console;

/**
 *
 * @author cmcarthur
 */
public class ConsoleOptionsViewable implements WebViewable {
    
    @Override
    public String toHTML() {
        String output = "";
        for (Console console : Console.values()) {
            output += "<option>" + console.getConsole() + "</option>";
        }
        return output;
    }
}
