package JavaCore.Generics;

public class Main {
    public static void main(String[] args) {
        SingleGenericHolder<Integer> iObj = new SingleGenericHolder<Integer>(10);
        System.out.println(iObj.getObj());

        System.out.println("-----------");

        DualGenericHolder<String, Integer> obj = new DualGenericHolder<>("SimpleCode", 10);
        obj.display();
    }
}
