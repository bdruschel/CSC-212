package hashmapvsbinarysearch;

import java.util.*;

public class storeHashMap {

    HashMap l;

    public storeHashMap() {
        l = new HashMap();
    }

    public boolean load(dictionaryEntry a) {
        if (l.containsKey(a.Word())) {
            return false;
        }
        l.put(a.Word(), a);
        return true;
    }

    public Object locate(String x) {
        return l.get(x);
    }
}
