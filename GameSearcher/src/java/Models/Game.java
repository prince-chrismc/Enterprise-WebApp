/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Arrays;
import java.sql.Date;

/**
 *
 * @author cmcarthur
 */
public class Game {
    private int game_id;
    private String name;
    private String description;
    private Console[] consoles;
    private int num_players;
    private boolean coop;
    private Genre[] genres;
    private Date release_date;
    private String developer;
    private String publisher;
    private String front_box_art;
    private String back_box_art;
    private String logo;
    private String developer_logo;
    private double price;
    private double discount;

    public Game() {
        consoles = new Console[0];
        genres = new Genre[0];
    }
    
    /**
     * @return the developer
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     * @param developer the developer to set
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the front_box_art
     */
    public String getFront_box_art() {
        return front_box_art;
    }

    /**
     * @param front_box_art the front_box_art to set
     */
    public void setFront_box_art(String front_box_art) {
        this.front_box_art = front_box_art;
    }

    /**
     * @return the back_box_art
     */
    public String getBack_box_art() {
        return back_box_art;
    }

    /**
     * @param back_box_art the back_box_art to set
     */
    public void setBack_box_art(String back_box_art) {
        this.back_box_art = back_box_art;
    }

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return the developer_logo
     */
    public String getDeveloper_logo() {
        return developer_logo;
    }

    /**
     * @param developer_logo the developer_logo to set
     */
    public void setDeveloper_logo(String developer_logo) {
        this.developer_logo = developer_logo;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the game_id
     */
    public int getGame_id() {
        return game_id;
    }

    /**
     * @param game_id the game_id to set
     */
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the consoles
     */
    public Console[] getConsoles() {
        return consoles;
    }
    
    /**
     * @return the consoles as string
     */
    public String getConsolesArrayAsString() {
        return Arrays.toString(consoles);
    }

    /**
     * @param consoles the consoles to set
     */
    public void setConsoles(Console[] consoles) {
        this.consoles = consoles;
    }

    /**
     * @return the num_players
     */
    public int getNum_players() {
        return num_players;
    }

    /**
     * @param num_players the num_players to set
     */
    public void setNum_players(int num_players) {
        this.num_players = num_players;
    }

    /**
     * @return the coop
     */
    public boolean isCoop() {
        return coop;
    }

    /**
     * @param coop the coop to set
     */
    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    /**
     * @return the genres
     */
    public Genre[] getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    /**
     * @return the release_date
     */
    public Date getRelease_date() {
        return release_date;
    }

    /**
     * @param release_date the release_date to set
     */
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
