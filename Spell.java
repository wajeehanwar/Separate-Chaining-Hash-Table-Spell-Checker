/**
* <h1>Separate Chaining Hash Table Spell Checker</h1>
* A pure java based spell checker utilizing separate chaining hash 
* tables
* <p>
* This program takes a command-line argument specifying the name of 
* the file containing common misspellings (a line-oriented file 
* with each comma-separated line containing a misspelled word and 
* the correct spelling), then reads text from standard input and 
* prints out the misspelled words in the text along with the line 
* numbers where they occurred and their correct spellings. 
* </p>
*
* @author  Wajeeh Anwar
* @version 1.0
* @since   2015-05-01
*/

public class Spell {
    public static void main(String[] args) {
        // Initialize symbol table.
        SeparateChainingHashST<String, String> st = 
                                new SeparateChainingHashST<String, String>();
        // Read filename from command line.
        In file = new In(args[0]);
        // Read lines in file.
        while (!file.isEmpty()) {
            // Split line in to 2 tokens.
            String[] field = file.readLine().split("\\,");
            // Load both tokens into symbol table.
            st.put(field[0], field[1]);
        }
        // Initialize line number tracker.
        int lineNumber = 1;
        // Read lines from StdIn.
        while (!StdIn.isEmpty()) {
            // Split line into individual words.
            String[] field = StdIn.readLine().split("\\ ");
            // Evaluate for each word.
            for (int i = 0; i < field.length; i++) {
                // Evaluate if word is misspelled.
                if (st.contains(field[i])) {
                    // Print misspelled word, line number and correction.
                    StdOut.println(field[i] + ":" + lineNumber 
                                        + " -> " + st.get(field[i])); 
                }
            }
            // Update line number.
            lineNumber++;
        }
    }
}
