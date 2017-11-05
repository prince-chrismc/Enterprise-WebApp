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
    PS1("PlayStation"),
    PS2("PlayStation 2"),
    PS3("PlayStation 3"),
    PS4("PlayStation 4"),
    XBOX("XBox"),
    XBOX360("XBox 360"),
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
