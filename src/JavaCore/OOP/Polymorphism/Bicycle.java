package JavaCore.OOP.Polymorphism;

public class Bicycle {
    static int gear;
    int speed;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        this.gear = decrement + 10;
    }

    public void speedUp(int increment) {
        this.speed += speed;
        this.gear -= 5;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "speed=" + speed + " gear " + gear +
                '}';
    }
}
