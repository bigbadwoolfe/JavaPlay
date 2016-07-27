package ch1;

import util.Question;

import java.util.HashMap;

/**
 * Created by Metodi on 2016-07-26.
 */
public class Permutations extends Question {
    String a1 = "cx";
    String a2 = "xc";
    String b1 = "cant";
    String b2 = "tanc";
    String c1 = "a";
    String c2 = "a";
    String d1 = "a";
    String d2 = "b";
    String e1 = "asss";
    String e2 = "sas";

    public Permutations() {
        super("1.3", "Given 2 strings, decide if one is a permutation of the other.");
    }

    public void run() {
        hello();

        System.out.printf("First: %4s; Second: %4s - %b\n", a1, a2, arePermutations(a1, a2));
        System.out.printf("First: %4s; Second: %4s - %b\n", b1, b2, arePermutations(b1, b2));
        System.out.printf("First: %4s; Second: %4s - %b\n", c1, c2, arePermutations(c1, c2));
        System.out.printf("First: %4s; Second: %4s - %b\n", d1, d2, arePermutations(d1, d2));
        System.out.printf("First: %4s; Second: %4s - %b\n", e1, e2, arePermutations(d1, e2));

        bye();
    }

    boolean arePermutations(String first, String second) {
        if (first.length() != second.length())
            return false;

        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();

        for (Character c : first.toCharArray()) {
            if (counts.containsKey(c)){
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }

        for (Character c : second.toCharArray()) {
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false;
            }

            counts.put(c, counts.get(c) - 1);
        }

        for(Character key : counts.keySet()) {
            if (counts.get(key) != 0) {
                return false;
            }
        }

        return true;
    }
}
