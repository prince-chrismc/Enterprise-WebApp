/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Genre;

/**
 *
 * @author cmcarthur
 */
public class GenreOptionsViewable implements WebViewable {
    
    @Override
    public String toHTML() {
        String output = "";
        for (Genre genre : Genre.values()) {
            if(genre == Genre.UNKNOWN) continue;
            output += "<option>" + genre.getGenre() + "</option>";
        }
        return output;
    }
}
