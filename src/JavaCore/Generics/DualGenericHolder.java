package JavaCore.Generics;

public class DualGenericHolder<T,Y> {
    T obj1;
    Y obj2;

    public DualGenericHolder(T obj1, Y obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public  void display() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
