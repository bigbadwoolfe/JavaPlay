package ch1;

import util.Question;

public class RotateMatrix extends Question {
    public RotateMatrix() {
        super("1.6", "Given an image represented by an NxN matrix, rotate by 90 degrees.");
    }

    int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

    int[][] b = {{1,2,3}, {4,5,6}, {7,8,9}};

    int[][] c ={{1,2}, {3, 4}};

    int[][] d = {{1,2,3,4, 5}, {6,7,8, 9, 10}, {11,12, 13,14,15 }, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

    public void run() {
        hello();

        boolean inPlace = false;

        System.out.println("2x2 Initial:");
        printInt2D(c);
        System.out.println("2x2 Rotated:");
        printInt2D(rotate(c, inPlace));
        System.out.println("3x3 Initial:");
        printInt2D(b);
        System.out.println("3x3 Rotated:");
        printInt2D(rotate(b, inPlace));
        System.out.println("4x4 Initial:");
        printInt2D(a);
        System.out.println("4x4 Rotated:");
        printInt2D(rotate(a, inPlace));
        System.out.println("x Initial:");
        printInt2D(d);
        System.out.println("5x5 Rotated:");
        printInt2D(rotate(d, inPlace));

        bye();
    }

    int[][] rotate(int[][] in, boolean simple) {
        if (simple) {
            return rotate(in);
        } else {
            return rotateInPlace(in);
        }
    }

    int[][] rotate(int[][] in) {
        if (in.length == 0 || in.length != in[0].length) {
            return in; // not a square matrix or empty matrix
        }

        int[][] res = new int[in.length][in.length];

        for (int row = 0; row < in.length; row++) {
            int[] cRow = in[row];

            for(int i = 0; i < cRow.length; i++) {
                int cCol = res.length - 1 - row;
                res[i][cCol] = cRow[i];
            }
        }
        return res;
    }

    int[][] rotateInPlace(int[][] in) {
        if (in.length == 0 || in.length != in[0].length) {
            return in; // not a square matrix or empty matrix
        }

        for (int layer = 0; layer < in.length/2; layer++) {
            int firstIndex = layer;
            int lastIndex = in.length - 1 - layer;

            for (int i = firstIndex; i < lastIndex; i++) {
                int offset = i - firstIndex;

                // save top
                int top = in[firstIndex][i];
                // left -> top
                in[firstIndex][i] = in[lastIndex - offset][firstIndex];
                // bottom -> left
                in[lastIndex - offset][firstIndex] = in[lastIndex][lastIndex - offset];
                // right -> bottom
                in[lastIndex][lastIndex - offset] = in[i][lastIndex];
                // temp -> right
                in[i][lastIndex] = top;
            }
        }

        return in;
    }
}
