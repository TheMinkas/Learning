package JavaCore.OOP.inheritance;

public class Main {
    public static void main(String[] args) {
        Mountain mountain = new Mountain(20, 10, 1);
        System.out.println(mountain);
        mountain.speedUp(2);
        System.out.println(mountain);
        mountain.applyBrake(1);
        System.out.println(mountain);

        Bicycle bicycle = new Bicycle(20, 10);

    }
}
