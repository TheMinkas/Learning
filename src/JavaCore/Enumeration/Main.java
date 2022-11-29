package JavaCore.Enumeration;

public class Main {
    public static void main(String[] args) {
        Color c1 = Color.RED;

        System.out.println(c1.name());
        System.out.println(c1.getValue());

        System.out.println("-------------");

        for(Color color : Color.values()) {
            System.out.print(color.getValue() + " ");
        }
    }

}
