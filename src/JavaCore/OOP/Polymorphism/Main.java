package JavaCore.OOP.Polymorphism;

public class Main {
    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();
        System.out.println(mo.multiply(1,2));
        System.out.println(mo.multiply(1.5, 1.5));
        System.out.println(mo.multiply(1,2,3));

        Bicycle bicycle = new Bicycle(10, 20);
        System.out.println(bicycle);
        bicycle.applyBrake(10);
        System.out.println(bicycle);
        bicycle.speedUp(5);
        System.out.println(bicycle);
    }
}
