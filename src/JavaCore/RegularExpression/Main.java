package JavaCore.RegularExpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения ");
        String birthDate = scanner.nextLine();
        //Шаблон дня Рождения
        Matcher matcher1 = Pattern.compile("^(((0[1-9]|[12]\\d|3[01])\\[\\/\\-\\.](0[13578]|1[02])[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)[\\/\\-\\.](0[13456789]|1[012])[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])[\\/\\-\\.]02[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|(29[\\/\\-\\.]02[\\/\\-\\.]((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$")
                .matcher(birthDate);
        if (birthDate.length() <= 0) {
            System.out.println("Дата рождения введена не корректно");
        }
        //Проверка на правильность написания дня рождения согласно шаблону
        if (matcher1.find()){
            System.out.println(birthDate);
        } else {
            System.out.println("Дата рождения введена не корректно!");
        }
    }
}
