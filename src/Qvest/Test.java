package Qvest;

public interface Test {
    void int1();
    default void int2() {
        System.out.println("hz");
    };
}
