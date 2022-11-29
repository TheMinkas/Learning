package ProductSystem;

import java.util.Scanner;

public class UserInput {

    public static String readUserInputString() {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        return inputLine;
    }

    public static int readUserInputInt() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int inputLine = scanner.nextInt();
            return inputLine;
        } else {
            System.out.println("Ошибка ввода. Вам нужно ввести число.");
            return readUserInputInt();
        }
    }

    public static double readUserInputDouble() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextDouble()) {
            double inputLine = scanner.nextDouble();
            return inputLine;
        } else {
            System.out.println("Ошибка ввода. Вам нужно ввести число.");
            return readUserInputDouble();
        }
    }
}
