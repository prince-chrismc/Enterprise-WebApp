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
package Services.Search;

import Models.Game;
import Models.SearchCriteria;
import Services.ResultsFormatting;
import Views.GameResultView;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class SearchByCriteriaService {

    private final ArrayList<Game> games;

    public SearchByCriteriaService(SearchCriteria criteria, String criteria_val, boolean signed_in) {
        if (null == criteria) {
            criteria = SearchCriteria.INVALID;
        }
        switch (criteria) {
            case NAME:
                SearchByNameService by_name = new SearchByNameService(criteria_val);
                games = by_name.getGames();
                break;

            case CONSOLE:
                SearchByConsoleService by_console = new SearchByConsoleService(criteria_val);
                games = by_console.getGames();
                break;

            case DISCOUNT:
                SearchByDiscountService by_discount = new SearchByDiscountService(signed_in);
                games = by_discount.getGames();
                break;
            case GENRE:
                SearchByGenreService by_genre = new SearchByGenreService(criteria_val);
                games = by_genre.getGames();
                break;
            case YEAR:
                SearchByYearService by_year = new SearchByYearService(Integer.parseInt(criteria_val));
                games = by_year.getGames();
                break;
            default:
                games = new ArrayList<Game>();
        }
    }

    public ArrayList<GameResultView> getViewableResults() {
        return ResultsFormatting.CreateViewableGameResults(games);
    }

}
