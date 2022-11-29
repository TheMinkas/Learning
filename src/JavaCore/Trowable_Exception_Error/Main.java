package JavaCore.Trowable_Exception_Error;

public class Main {
    public static void main(String[] args) {
//        WriterHelper writerHelper = new WriterHelper();
//        writerHelper.writeList();

        int result = division(55, 0);
        System.out.println(result);
    }
    public static int division(int a, int b) {

        if(b==0)
            try {
                throw new MyMathException("The division cannot be zero");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return 0;
            }

        return a/b;
    }
}

class MyMathException extends Exception{
    public MyMathException(String msg) {
        super(msg);
    }
}

