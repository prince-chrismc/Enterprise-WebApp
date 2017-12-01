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

        for (String retval : data.split(";")) { // https://www.tutorialspoint.com/java/java_string_split.htm
            DatabaseEntries.add(getValueFromString(retval));
        }

        return DatabaseEntries.toArray(new Genre[DatabaseEntries.size()]); // http://viralpatel.net/blogs/convert-arraylist-to-arrays-in-java/
    }

    private Genre getValueFromString(String entry) {
        for (Genre genre : Genre.values()) {
            if (entry.equalsIgnoreCase(genre.getGenre())) {
                return genre;
            }
        }
        return Genre.UNKNOWN; // default
    }

    public Genre[] getGenres() {
        return genres;
    }
}
