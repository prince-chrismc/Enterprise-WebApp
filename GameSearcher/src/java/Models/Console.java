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
public enum Console {
    PS1("Playstation"),
    PS2("Playstation2"),
    PS3("Playstation3"),
    PS4("Playstation4"),
    XBOX("XBox"),
    XBOX360("XBox360"),
    XBOX1("XBox1"),
    PC("PC");
    
    private final String console;
        
    Console(String console) {
        this.console = console;
    }
    
    public String getConsole() {
        return this.console;
    }
    
    /* Iteration Eample
        for (Console console : Console.values()) {
            System.out.println(console);
        }
    */
}
