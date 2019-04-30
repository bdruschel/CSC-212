/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapvsbinarysearch;

import java.io.FileInputStream;
import java.util.Scanner;

public class HASHMAPvsBINARYSEARCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        storeHashMap h = new storeHashMap();
        storeArrayList a = new storeArrayList();
        Scanner reader = new Scanner(new FileInputStream("dict.txt"));
        Scanner keyboard = new Scanner(System.in);
        while (reader.hasNextLine()) {
            Scanner lineScanner = new Scanner(reader.nextLine());
            lineScanner.useDelimiter("\t");
            dictionaryEntry d = new dictionaryEntry(lineScanner.next(), lineScanner.next());
            //System.out.println(d.Word() + " " + d.Def());

            h.load(d);
            a.load(d);
        }
        int n = 0;

        Scanner testing = new Scanner(new FileInputStream("testingLocate.txt"));
        long timeBefore = System.currentTimeMillis();

        while (testing.hasNextLine()) {//look for 40,000 words in ArrayList
            n++;
            Scanner lineScanner = new Scanner(testing.nextLine());
            lineScanner.useDelimiter("\t");
            String word = lineScanner.next();
            dictionaryEntry d1 = (dictionaryEntry) a.locate(word);
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("ArrayList Time " + (timeAfter - timeBefore));
        testing.close();

        testing = new Scanner(new FileInputStream("testingLocate.txt"));
        timeBefore = System.currentTimeMillis();
        while (testing.hasNextLine()) {//look for 40,000 words in HashMap
            Scanner lineScanner = new Scanner(testing.nextLine());
            lineScanner.useDelimiter("\t");
            String word = lineScanner.next();
            dictionaryEntry d1 = (dictionaryEntry) h.locate(word);
        }
        timeAfter = System.currentTimeMillis();
        System.out.println("HashMap Time " + (timeAfter - timeBefore));

    }
}


