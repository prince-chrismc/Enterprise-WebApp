/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Game;
import Models.SearchCriteria;
import Views.GameResultViewable;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class SearchByCriteriaService {
    private final ArrayList<Game> games;
    
    public SearchByCriteriaService(SearchCriteria criteria, String criteria_val) {
        if(null == criteria) criteria = SearchCriteria.INVALID;
        switch(criteria) {
            case NAME: 
                SearchByNameService by_name = new SearchByNameService(criteria_val);
                games = by_name.getGames();
                break;
                
            case CONSOLE:
                SearchByConsoleService by_console = new SearchByConsoleService(criteria_val);
                games = by_console.getGames();
                break;
                
            default: games = new ArrayList<Game>();
        }
    }
    
    public ArrayList<GameResultViewable> getViewableResults() {
        return ResultsFormatting.CreateViewableGameResults(games);
    }
    
}
