package JavaCore.NestedClass;

//Внешний класс
public class StaticOuterClass {
    static int outerStaticMember = 10;
    int instanceMember = 20;
    private static int outerPrivateMember = 30;



    //Внутренний класс
    static class StaticNestedClass {
        void display() {
            System.out.println("Static member of outer class = " + outerStaticMember);

            System.out.println("Private static member of outer class = " + outerPrivateMember);


        }
    }


}
