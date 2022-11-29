package JavaCore.OOP.Polymorphism;

public class MethodOverloading {
    public int multiply(int x, int y) {
        return (x*y);
    }

    public double multiply(double x, double y) {
        return (x+y);
    }

    public int multiply(int x, int y, int z) {
        return (x*y) + z;
    }


}
