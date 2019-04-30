package comparisonwithdictionary;

import java.util.*;
public class storeArrayList {
    ArrayList<dictionaryEntry> l;
    public storeArrayList () {
        l = new <dictionaryEntry> ArrayList();
    }
    public boolean load (dictionaryEntry x) {
        if (locate(x.Word()) != null) {
            return false;
        }
        else {
            l.add(x);
        }
        return true;
    }
    
    public Comparable locate (String x) {
        for (int i = 0; i <l.size(); i++) {
            if (l.get(i).compareTo(x) == 0) {
                return l.get(i);
            }
        }
        return null;
    }
}
