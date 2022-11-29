package JavaCore.Recursion;

public class ComplexFunction {

    int calculateFactorial(int n) {
        //Если факториал 1 = 1 то это выход из программы
        if (n==1) {
            return 1;
        } else  {
            return (n*calculateFactorial(n-1));
        }
    }
}
