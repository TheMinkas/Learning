package JavaCore.NestedClass;

public class Main {
    public static void main(String[] args) {
        StaticOuterClass.StaticNestedClass nestedObject = new StaticOuterClass.StaticNestedClass();
        nestedObject.display();
        System.out.println("-------------");

        InnerOuterClass.InnerClass in = new InnerOuterClass().new InnerClass();
        in.display();
        System.out.println("-------------");

        InnerOuterClass innerOuterClass = new InnerOuterClass();
        innerOuterClass.outerClassMethod();

    }

    static {
        System.out.println("Ку");
        System.out.println("-------------");
    }

}
