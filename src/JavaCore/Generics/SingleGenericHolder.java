package JavaCore.Generics;

public class SingleGenericHolder<T> {
    T obj;

    SingleGenericHolder(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}
