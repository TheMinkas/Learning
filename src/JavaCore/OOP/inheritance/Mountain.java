package JavaCore.OOP.inheritance;

public class Mountain extends Bicycle{
    public int seatHeight;

    public Mountain(int seatHeight, int startGear, int startSpeed) {
        super(startGear, startSpeed);
        this.seatHeight = seatHeight;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    public String toString() {
        return "Mountain bike has: Gear = " + this.gear + ", speed = " + this.speed + ", seat height = " + this.seatHeight;
    }
}
