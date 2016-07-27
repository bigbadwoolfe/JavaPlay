package ch1;

import util.Question;

public class AllUnique extends Question {

    String unique1 = "asdfgkjdh";
    String unique2 = "TheLazyBrFoxJumps";
    String unique3 = "abc";

    public AllUnique() {
        super("1.1", "Algorithm to determine if a string has all unique characters w/o using additional data structures.");
    }

    public void run() {
        hello();
        System.out.println("Assuming ASCII:");
        System.out.printf("%s - %1b\n", unique1, hasAllUniqueChars(unique1));
        System.out.printf("%s - %1b\n", unique2, hasAllUniqueChars(unique2));
        System.out.printf("%s - %1b\n", unique3, hasAllUniqueChars(unique3));
        System.out.println();
        System.out.println("Assuming ASCII a-z:");
        System.out.printf("%s - %1b\n", unique1, hasAllUniqueChars2(unique1));
        System.out.printf("%s - %1b\n", unique3, hasAllUniqueChars2(unique3));

        bye();
    }

    /**
     * Assumes ASCII
     */
    boolean hasAllUniqueChars(String str) {
        /* Assuming ASCII - hence in total 127 characters */

        if (str.length() > 127) {
            return false;
        }

        boolean[] chars = new boolean[127];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (chars[val]) {
                return false;
            }
            chars[val] = true;
        }

        return true;
    }

    /**
     * Assumes a-z ASCII only
     **/
    boolean hasAllUniqueChars2(String str) {

        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';

            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }
        return true;
    }

}
