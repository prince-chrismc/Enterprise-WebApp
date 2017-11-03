/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Console;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class DatabaseConsoleConverter {
    private enum DatabaseConsoleEntries {
        PS1("PS"),
        PS2("PS2"),
        PS3("PS3"),
        PS4("PS4"),
        XBOX("XBOX"),
        XBOX360("XBOX360"),
        XBOX1("XBOX1"),
        PC("PC");
        
        private final String console;
        
        DatabaseConsoleEntries(String entry) {
            this.console = entry;
        }
        
        @Override
        public String toString() {
            return console;
        }
        
        public static DatabaseConsoleEntries getValueFromString(String entry) {
            for(DatabaseConsoleEntries console : DatabaseConsoleEntries.values()) {
                if(entry.equalsIgnoreCase(console.toString())) return console;
            }
            return PS2; // default
        }
    }
    
    private Console[] consoles;
    
    public DatabaseConsoleConverter(String data) {
        consoles = parseDatabaseConsoleEntry(data);
    }
    
    public Console[] getConsoles() {
        return consoles;
    }
    
    private static Console convert(DatabaseConsoleEntries entry) {
        switch(entry)
        {
            case PS1: return Console.PS1;
            case PS2: return Console.PS2;
            case PS3: return Console.PS3;
            case PS4: return Console.PS4;
            case XBOX: return Console.XBOX;
            case XBOX360: return Console.XBOX360;
            case XBOX1: return Console.XBOX1;
            case PC: return Console.PC;
            default: return Console.PS2;
        }
    }
    
    private Console[] parseDatabaseConsoleEntry(String data) {
        ArrayList<DatabaseConsoleEntries> DatabaseEntries = new ArrayList<DatabaseConsoleEntries>();
        
        for (String retval: data.split(";")) { // https://www.tutorialspoint.com/java/java_string_split.htm
            DatabaseEntries.add(DatabaseConsoleEntries.getValueFromString(retval));
        }
        
        consoles = new Console[DatabaseEntries.size()]; // http://viralpatel.net/blogs/convert-arraylist-to-arrays-in-java/
        int index_counter = 0;
        
        for(DatabaseConsoleEntries entry : DatabaseEntries) {
            consoles[index_counter++] = convert(entry);
        }
        
        return consoles;
    }
}
