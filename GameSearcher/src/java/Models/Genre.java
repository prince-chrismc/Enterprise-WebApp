/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author cmcarthur
 */
public enum Genre {
    RACING("Racing"),
    SHOOTER("Shooter");
    
    private final String genre;
    
    Genre(String genre) {
        this.genre = genre;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    /* Iteration Eample
        for (Genre genre : Genre.values()) {
            System.out.println(genre);
        }
    */
}
