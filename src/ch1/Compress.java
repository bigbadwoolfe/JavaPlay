package ch1;

import util.Question;

public class Compress extends Question {
    public Compress() {
        super("1.5", "Method to perform basic string compression using counts of repeated chars.");
    }

    String a = "aabbbcccddddeeeeee";
    String b = "abcdeee";
    String c = "ababababab";
    String d = "ab";
    String e = "aab";
    String f = "aaab";
    String g = "aaaab";
    String h = "aaaaab";

    public void run() {
        hello();

        System.out.printf("In: %20s | Out: %s\n", a, compress(a));
        System.out.printf("In: %20s | Out: %s\n", b, compress(b));
        System.out.printf("In: %20s | Out: %s\n", c, compress(c));
        System.out.printf("In: %20s | Out: %s\n", d, compress(d));
        System.out.printf("In: %20s | Out: %s\n", e, compress(e));
        System.out.printf("In: %20s | Out: %s\n", f, compress(f));
        System.out.printf("In: %20s | Out: %s\n", g, compress(g));
        System.out.printf("In: %20s | Out: %s\n", h, compress(h));

        bye();
    }

    String compress (String in) {
        String compressed = compressString(in);
        return compressed.length() < in.length() ? compressed : in;
    }

    String compressString(String in) {
        if (in.length() <= 2) {
            return in;
        }

        StringBuilder res = new StringBuilder();
        Character prev = in.charAt(0);
        int cCount = 0;

        for (int i = 0; i < in.length(); i++) {
            Character cur = in.charAt(i);

            if (cur != prev) {
                res.append(prev);
                res.append(cCount);
                prev = cur;
                cCount = 1;
            } else {
                cCount++;
            }
        }

        res.append(prev);
        res.append(cCount);

        return res.toString();
    }

}
