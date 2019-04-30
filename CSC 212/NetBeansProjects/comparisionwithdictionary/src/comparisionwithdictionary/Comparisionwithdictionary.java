package comparisionwithdictionary;

import java.io.FileInputStream;
import java.util.*;

/**
 *
 * @author csc212
 */
public class Comparisionwithdictionary {

    


    public static void main(String[] args) throws Exception {
        storeHashMap h = new storeHashMap();
        storeArrayList a = new storeArrayList();
        Scanner reader = new Scanner(new FileInputStream("dict.txt"));
        Scanner keyboard = new Scanner(System.in);
        while (reader.hasNextLine()) {

            Scanner lineScanner = new Scanner(reader.nextLine());
            lineScanner.useDelimiter("\t");
            DictionaryENtry d = new DictionaryENtry(lineScanner.next(), lineScanner.next());
            //System.out.println(d.Word() + " " + d.Def());

            h.load(d);
            a.load(d);
        }
        a.sort(a.l);
        int n = 0;

        Scanner testing = new Scanner(new FileInputStream("testingLocate.txt"));
        long timeBefore = System.currentTimeMillis();
        try {
            while (testing.hasNextLine()) {//look for 40,000 words in ArrayList
                n++;

                Scanner lineScanner = new Scanner(testing.nextLine());
                lineScanner.useDelimiter("\t");
                String word = lineScanner.next();
                DictionaryENtry d1 = (DictionaryENtry) a.locate(word);

            }
        } catch (NoSuchElementException e) {
            System.out.println("died when reading line " + n);
        }
        long timeAfter = System.currentTimeMillis();
        System.out.println("ArrayList Time " + (timeAfter - timeBefore));
        testing.close();

        testing = new Scanner(new FileInputStream("testingLocate.txt"));
        timeBefore = System.currentTimeMillis();
        while (testing.hasNextLine()) { //look for 40,000 words in HashMap
            Scanner lineScanner = new Scanner(testing.nextLine());
            lineScanner.useDelimiter("\t");
            String word = lineScanner.next();
            DictionaryENtry d1 = (DictionaryENtry) h.locate(word);
        }
        timeAfter = System.currentTimeMillis();
        System.out.println("HashMap Time " + (timeAfter - timeBefore));

    }
}
