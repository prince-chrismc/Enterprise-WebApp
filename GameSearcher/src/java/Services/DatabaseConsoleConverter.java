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
        
        public static DatabaseConsoleEntries getValueFromString(String entry) {
            if(entry.equalsIgnoreCase(PS1.console)) return PS1; 
            if(entry.equalsIgnoreCase(PS2.console)) return PS2;
            if(entry.equalsIgnoreCase(PS3.console)) return PS3;
            if(entry.equalsIgnoreCase(PS4.console)) return PS4;
            
            if(entry.equalsIgnoreCase(XBOX.console)) return XBOX;
            if(entry.equalsIgnoreCase(XBOX360.console)) return XBOX360;
            if(entry.equalsIgnoreCase(XBOX1.console)) return XBOX1;
            
            if(entry.equalsIgnoreCase(PC.console)) return PC;
            
            return PS2; // default
        }
    }
    
    private ArrayList<DatabaseConsoleEntries> DatabaseEntries;
    private Console[] consoles;
    
    public DatabaseConsoleConverter(String data) {
        DatabaseEntries = new ArrayList<DatabaseConsoleEntries>();
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
        for (String retval: data.split(";")) {
            DatabaseEntries.add(DatabaseConsoleEntries.getValueFromString(retval));
        }
        
        consoles = new Console[DatabaseEntries.size()];
        int index_counter = 0;
        
        for(DatabaseConsoleEntries entry : DatabaseEntries) {
            consoles[index_counter++] = convert(entry);
        }
        
        return consoles;
    }
}
