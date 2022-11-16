package JavaCore.OOP.Abstract;

public abstract class GraphicObject {
    int x, y;

    void moveTo(int newX, int newY) {
        System.out.println("move to x: " + this.x + "move to y: " + this.y);
    }

    abstract void draw();
    abstract  void resize();
}
