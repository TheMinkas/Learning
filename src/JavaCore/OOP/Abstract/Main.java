package JavaCore.OOP.Abstract;

public class Main {
    public static void main(String[] args) {
        GraphicObject rectangle = new Rectangle();
        rectangle.draw();
        rectangle.resize();

        Rectangle rectangle1 = new Rectangle();
        rectangle1.draw();
        rectangle1.resize();
    }
}
