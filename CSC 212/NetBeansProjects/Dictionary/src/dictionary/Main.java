package dictionary;

import java.io.*;
import java.util.*;

/**
 *
 * @author Brandon
 */
public class Main {

    public static char menu(Scanner kb) {
        String c;
        do {
            System.out.println("\nMENU ");
            System.out.println("1. Find Word");
            System.out.println("2. Change Definition");
            System.out.println("3. Add Word / Definition");
            System.out.println("4. Delete Word");
            System.out.println("5. Browse");
            System.out.println("6. Quit");

            System.out.print("\nChoice: ");
            c = kb.next().toUpperCase();
            System.out.println();
        } while (c.charAt(0) != '1' && c.charAt(0) != '2' && c.charAt(0) != '3'
                && c.charAt(0) != '4' && c.charAt(0) != '5' && c.charAt(0) != '6');
        return c.charAt(0);
    }

    public static void main(String[] args) throws FileNotFoundException {

        Dictionary d = new Dictionary();
        Scanner reader = new Scanner(new FileInputStream("dict.txt"));
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        while (reader.hasNextLine()) {
            Scanner lineScanner = new Scanner(reader.nextLine());

            lineScanner.useDelimiter("\t");
            dictionaryEntry di = new dictionaryEntry(lineScanner.next(), lineScanner.next());
            //System.out.println(d.Word() + " " + d.Def());

            d.load(di);
        }

    //d.browse("salty"); //tests the browse method
    
        for (;;) {
            char o = menu(in);
            switch (o) {
                case '1': //find a word
                    System.out.print("Enter Word: ");
                    String w = in2.nextLine();
                    dictionaryEntry de = (dictionaryEntry)d.find(w);
                    
                    if (de == null) {
                        System.out.println("WORD NOT FOUND");
                    } else {
                        System.out.println("Definition: " + de.Def());
                    }
                    break;

                case '2': //change definition
                    System.out.print("Enter Word: ");
                    w = in2.nextLine();
                    de = (dictionaryEntry)d.find(w);
                    
                    if (d.find(w) == null) {
                        System.out.println("WORD NOT FOUND");
                    } else {
                        System.out.println("Current Definition: " + de.Def());
                        System.out.print("Enter a new definition: ");
                        String def = in2.nextLine();
                        d.newDef(w, def);
                    }
                    break;

                case '3': //add word/definition
                    System.out.println("Enter Word: ");
                    w = in2.nextLine();

                    if (d.find(w) != null) {
                        System.out.println("WORD ALREADY EXISTS");
                    } else {
                        System.out.print("Enter a definition: ");
                        String def = in2.nextLine();
                        d.Add(w, def);

                        System.out.println("Word / Definition added.");
                    }
                    break;

                case '4': //delete
                    System.out.print("Enter Word: ");
                    w = in2.nextLine();

                    if (d.find(w) == null) {
                        System.out.println("WORD NOT FOUND");
                    } else {
                        d.Delete(w);
                        System.out.println("'" + w + "' " + "has been terminated.");
                    }
                    break;

                case '5': //browse
                    System.out.print("Enter a string: ");
                    w = in2.nextLine();
                    d.browse(w);
                    break;
                    
                case '6': //exit
                    System.out.println("Goodnight, sweet prince.");
                    System.exit(0);
            }
        }

    }

}
