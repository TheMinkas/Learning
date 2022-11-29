package Qvest;

public class Logic {

    public boolean test1(boolean x, boolean y) {
        if (x == true && y == true ) {
            return true;
        } else if (x == true && y == false) {
            return false;
        } else if (x == false && y == true) {
            return false;
        } else {
            return false;
        }
    }
}
