package test;

import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public class Test {

    public static void main(String[] args) {

        ArrayList<String> a = new ArrayList(3);

        a.add("hello");
        a.add("goodbye");
        a.add("next");

        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).startsWith("g")) {
                System.out.println(a.get(i));
            }
        }

    }

}


