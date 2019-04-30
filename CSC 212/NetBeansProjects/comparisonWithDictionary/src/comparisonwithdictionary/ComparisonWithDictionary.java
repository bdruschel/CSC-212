/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparisonwithdictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class ComparisonWithDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        storeHashMap h = new storeHashMap();
        storeArrayList a = new storeArrayList();
        Scanner reader = new Scanner(new FileInputStream("dict.txt"));
        Scanner keyboard = new Scanner(System.in);
        while (reader.hasNextLine()) {
            dictionaryEntry d = new dictionaryEntry(reader.next(), reader.nextLine());
            //System.out.println(d.Word() + " " + d.Definition());
            h.load(d);
            a.load(d);
        }

        for (;;) {
            System.out.print("Enter a Word: ");
            String name = keyboard.next();
            long timeBefore = System.currentTimeMillis();
            dictionaryEntry d1 = (dictionaryEntry) a.locate(name);
            long timeAfter = System.currentTimeMillis();
            System.out.println("arrayList Time: " + (timeAfter - timeBefore));
            timeBefore = System.currentTimeMillis();
            dictionaryEntry d2 = (dictionaryEntry) h.locate(name);

            timeAfter = System.currentTimeMillis();
            System.out.println("hashMap Time: " + (timeAfter - timeBefore));
            System.out.println("Definition from ArrayList: " + d1.Definition());
            System.out.println("Defnition from hashMap: " + d2.Definition());
        }
        
    }
    
}
