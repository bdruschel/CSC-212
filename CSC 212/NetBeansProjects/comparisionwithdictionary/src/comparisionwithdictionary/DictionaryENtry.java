/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparisionwithdictionary;

/**
 *
 * @author CSC212
 */
public class DictionaryENtry implements Comparable {

    String word;
    String def;

    public DictionaryENtry(String w, String d) {
        word = w;
        def = d;

    }

    public String Word() {
        return word;
    }

    public String Def() {
        return def;
    }

    public int compareTo(Object a) {
        return word.compareTo((String) a);

    }
}
