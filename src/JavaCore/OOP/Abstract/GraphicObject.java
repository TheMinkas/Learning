package JavaCore.OOP.Abstract;

public abstract class GraphicObject {
    int x, y;

    void moveTo(int newX, int newY) {
        System.out.println("move to x: " + (this.x + newX) + ", move to y: " + (this.y+newY));
    }

    abstract void draw();
    abstract  void resize();
}
