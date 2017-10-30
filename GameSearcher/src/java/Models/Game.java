/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

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
    private Data release_date;
    private String developer;
    private String publisher;
    private String front_box_art;
    private String back_box_art;
    private String logo;
    private String developer_logo;
    private String price;
    private String discount;

    /**
     * @return the game_id
     */
    public String getGame_id() {
        return game_id;
    }

    /**
     * @param game_id the game_id to set
     */
    public void setGame_id(String game_id) {
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
     * @return the console
     */
    public String getConsole() {
        return console.getConsole();
    }

    /**
     * @param console the console to set
     */
    public void setConsole(Console console) {
        this.console = console;
    }

    /**
     * @return the num_players
     */
    public String getNum_players() {
        return num_players;
    }

    /**
     * @param num_players the num_players to set
     */
    public void setNum_players(String num_players) {
        this.num_players = num_players;
    }

    /**
     * @return the coop
     */
    public boolean getCoop() {
        return coop;
    }

    /**
     * @param coop the coop to set
     */
    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    /**
     * @return the genre
     */
    public Genre[] getGenre() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenre(Genre[] genres) {
        this.genres = genres;
    }

    /**
     * @return the release_date
     */
    public String getRelease_date() {
        return release_date;
    }

    /**
     * @param release_date the release_date to set
     */
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
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
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
