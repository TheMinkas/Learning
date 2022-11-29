package Calculator;

import java.util.Scanner;

public class UserInput {

    public static String read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: " );
        String inputLine = scanner.nextLine();

        scanner.close();
        return inputLine;
    }

}
