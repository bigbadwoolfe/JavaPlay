package ch1;

import util.Question;

public class ReplaceSpaces extends Question {

    String a = "ab c d";

    public ReplaceSpaces() {
        super("1.4", "Method to replace all spaces in a string with '%20'. Implemented using char array");
    }

    public void run() {
        hello();
        System.out.printf("In: %s\n", a);
        System.out.printf("Out: %s\n", replaceSpaces(a.toCharArray(), 12));
        bye();
    }

    String replaceSpaces(char[] arr, int trueLength) {
        char[] replaced = new char[trueLength];

        for (int i = arr.length - 1; i >= 0; i--) {
            char cur = arr[i];

            if (cur == ' ') {
                replaced[--trueLength] = '0';
                replaced[--trueLength] = '2';
                replaced[--trueLength] = '%';
            } else {
                replaced[--trueLength] = cur;
            }
        }

        return String.valueOf(replaced);
    }
}
