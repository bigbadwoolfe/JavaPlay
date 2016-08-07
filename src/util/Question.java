package util;

public abstract class Question {
    String number;
    String description;

    public Question(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String toString() {
        return String.format("%s - %s", this.number, this.description);
    }

    public void hello() {
        System.out.println(this.toString());
        System.out.println("--------------------------");
    }

    public void bye() {
        System.out.println("--------------------------");
    }


    public void printInt2D (int[][] in) {
        for (int row = 0; row < in.length; row++) {
            for (int col = 0; col < in[row].length; col++) {
                System.out.print(String.format("%3d", in[row][col]));
            }
            System.out.println();
        }
    }

    public abstract void run();

}
