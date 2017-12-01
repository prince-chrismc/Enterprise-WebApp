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

import Models.Console;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class DatabaseConsoleConverter {

    private enum DatabaseConsoleEntries {
        PS1("PS1"),
        PS2("PS2"),
        PS3("PS3"),
        PS4("PS4"),
        XBOX("XBOX1"),
        XBOX360("XBOX360"),
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
            for (DatabaseConsoleEntries console : DatabaseConsoleEntries.values()) {
                if (entry.equalsIgnoreCase(console.toString())) {
                    return console;
                }
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
        switch (entry) {
            case PS1:
                return Console.PS1;
            case PS2:
                return Console.PS2;
            case PS3:
                return Console.PS3;
            case PS4:
                return Console.PS4;
            case XBOX:
                return Console.XBOX;
            case XBOX360:
                return Console.XBOX360;
            case PC:
                return Console.PC;
            default:
                return Console.PS2;
        }
    }

    private Console[] parseDatabaseConsoleEntry(String data) {
        ArrayList<DatabaseConsoleEntries> DatabaseEntries = new ArrayList<DatabaseConsoleEntries>();

        for (String retval : data.split(";")) { // https://www.tutorialspoint.com/java/java_string_split.htm
            DatabaseEntries.add(DatabaseConsoleEntries.getValueFromString(retval));
        }

        consoles = new Console[DatabaseEntries.size()]; // http://viralpatel.net/blogs/convert-arraylist-to-arrays-in-java/
        int index_counter = 0;

        for (DatabaseConsoleEntries entry : DatabaseEntries) {
            consoles[index_counter++] = convert(entry);
        }

        return consoles;
    }

    public static String getDatabaseEntry(Console console) {
        if (null == console) {
            return DatabaseConsoleEntries.PS2.toString();
        } else {
            switch (console) {
                case PS1:
                    return DatabaseConsoleEntries.PS1.toString();
                case PS2:
                    return DatabaseConsoleEntries.PS2.toString();
                case PS3:
                    return DatabaseConsoleEntries.PS3.toString();
                case PS4:
                    return DatabaseConsoleEntries.PS4.toString();
                case XBOX:
                    return DatabaseConsoleEntries.XBOX.toString();
                case XBOX360:
                    return DatabaseConsoleEntries.XBOX360.toString();
                case PC:
                    return DatabaseConsoleEntries.PC.toString();
                default:
                    return DatabaseConsoleEntries.PS2.toString();
            }
        }
    }
}
