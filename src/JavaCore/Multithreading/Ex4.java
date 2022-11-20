package JavaCore.Multithreading;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
            }
        }).start();

        new Thread(() -> {
            for(int i = 1; i<=1000; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
