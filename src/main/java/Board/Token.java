package Board;

public class Token {
    private String color;
    private int point;

    public Token(String color, int point) {
        this.color = color;
        this.point = point;
    }

    public void printToken() {
        System.out.println("Your Token: " + color + ", Points: " + point);
    }
}
