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

    public abstract void run();

}
