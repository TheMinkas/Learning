package JavaCore.OOP.Interfaces;

public class Main {
    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike(1, 10, 20);
        System.out.println(mountainBike.getSeatHeight());
        System.out.println(mountainBike.getGear());
        System.out.println(mountainBike.getSpeed());

        mountainBike.applyBrake(1);
        System.out.println(mountainBike.getSpeed());

        mountainBike.speedUp(2);
        System.out.println(mountainBike.getSpeed());

    }
}
