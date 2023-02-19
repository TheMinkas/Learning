package MyPrograms.Calculator;

public class Main {
    public static void main(String[] args) {
        final String inputExp = UserInput.read();
        Converter converter = new Converter();


        String[] action = {"+", "-", "/", "*"};
        String[] actionRegex = {"\\+", "-", "/", "\\*"};

        int indexCheck = -1;
        //Необходимо проверить содержит ли массив action, необходимый символ
        for (int i = 0; i<action.length; i++) {
            if(inputExp.contains(action[i])) {
                indexCheck = i;
                break;
            }
        }

        if (indexCheck == -1) {
            System.out.println("Вы ввели не верный арифметический оператор");
            return;
        }

        //Из строки нужно достать 2 числа, без символа и положить их в массив
        String[] data = inputExp.split(actionRegex[indexCheck]);

        int result = 0;

        //Проверить римские цифры или нет
            //Приравнять к x=data[0]; y = data[1]
            int x = Integer.parseInt(converter.isRoman(data[0]));
            int y = Integer.parseInt(converter.isRoman(data[1]));

            //Проверить на символ и выполнить расчёт
            switch (action[indexCheck]) {
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                default:
                    result = x / y;
                    break;
            }

        System.out.println(result);
    }
}
