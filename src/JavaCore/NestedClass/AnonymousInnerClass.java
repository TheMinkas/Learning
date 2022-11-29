package JavaCore.NestedClass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Bicycle mBike = new MountainBike();
        mBike.canApplyBreak();
        mBike.canSpeedUp();
        System.out.println("--------");


        Bicycle bicycle = new Bicycle() {
            @Override
            public void canSpeedUp() {
                System.out.println("Anon can speed up MBike");
            }

            @Override
            public void canApplyBreak() {
                System.out.println("Anon can speed up MBike");
            }
        };
        bicycle.canSpeedUp();
        bicycle.canApplyBreak();
    }
}
