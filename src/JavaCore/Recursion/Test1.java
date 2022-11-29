package JavaCore.Recursion;

public class Test1 {
    public int count(int x) {
        if (x == 10) {
            return x;
        }
        x++;
        return count(x);
    }

    public int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        return x * factorial(x-1);
    }
}
