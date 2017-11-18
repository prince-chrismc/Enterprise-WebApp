/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Genre;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class DatabaseGenreConverter {
    
    private final Genre[] genres;
    
    public DatabaseGenreConverter(String data) {
        genres = parseDatabaseGenreEntry(data);
    }

    private Genre[] parseDatabaseGenreEntry(String data) {
        ArrayList<Genre> DatabaseEntries = new ArrayList<Genre>();
        
        for (String retval: data.split(";")) { // https://www.tutorialspoint.com/java/java_string_split.htm
            DatabaseEntries.add(getValueFromString(retval));
        }
        
        return DatabaseEntries.toArray(new Genre[DatabaseEntries.size()]); // http://viralpatel.net/blogs/convert-arraylist-to-arrays-in-java/
    }

    private Genre getValueFromString(String entry) {
        for(Genre genre : Genre.values()) {
            if(entry.equalsIgnoreCase(genre.getGenre())) return genre;
        }            
        return Genre.UNKNOWN; // default
    }
    
    public Genre[] getGenres() {
        return genres;
    }
}
